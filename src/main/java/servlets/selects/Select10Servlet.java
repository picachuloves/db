package servlets.selects;

import connection.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Select10Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select10.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        List<Table> list = new ArrayList<>();
        try {
            list = doQuery(id_room);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }

    private List<Table> doQuery(int id_room) throws SQLException{
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select clients.id, fio, bill, review, add_service from clients inner join contracts on clients.id=contracts.id_client left join reviews using(id_client) inner join bills on id_contract=contract_number inner join added_services using(bill_number) where contracts.id_room=?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_room);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setFio(resultSet.getString("fio"));
                row.setBill(resultSet.getBigDecimal("bill"));
                row.setReview(resultSet.getString("review"));
                row.setAdd_service(resultSet.getString("add_service"));
                list.add(row);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public class Table{
        private int id;
        private String fio;
        private BigDecimal bill;
        private String review;
        private String add_service;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFio() {
            return fio;
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        public BigDecimal getBill() {
            return bill;
        }

        public void setBill(BigDecimal bill) {
            this.bill = bill;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        public String getAdd_service() {
            return add_service;
        }

        public void setAdd_service(String add_service) {
            this.add_service = add_service;
        }
    }
}
