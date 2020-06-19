package servlets.selects;

import connection.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select14Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select14.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_client = Integer.parseInt(req.getParameter("id_client"));
        List<Table> list = new ArrayList<>();
        try {
            list = doQuery(id_client);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }


    private List<Table> doQuery(int id_client) throws SQLException{
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select COUNT(*) as \"Visiting number\", contracts.id_room, contracts.living_start, contracts.living_end, bills.bill from clients inner join contracts on clients.id=contracts.id_client and clients.id = ? inner join bills on bills.id_contract=contracts.contract_number group by id_room, living_start, living_end, bill;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_client);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Table row = new Table();
                row.setCount(resultSet.getInt("Visiting number"));
                row.setId_room(resultSet.getInt("id_room"));
                row.setLiving_start(resultSet.getDate("living_start"));
                row.setLiving_end(resultSet.getDate("living_end"));
                row.setBill(resultSet.getBigDecimal("bill"));
                list.add(row);
            }

        }catch (SQLException ex) {
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
        private int count;
        private int id_room;
        private Date living_start;
        private Date living_end;
        private BigDecimal bill;

        public BigDecimal getBill() {
            return bill;
        }

        public void setBill(BigDecimal bill) {
            this.bill = bill;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public int getId_room() {
            return id_room;
        }

        public void setId_room(int id_room) {
            this.id_room = id_room;
        }

        public Date getLiving_start() {
            return living_start;
        }

        public void setLiving_start(Date living_start) {
            this.living_start = living_start;
        }

        public Date getLiving_end() {
            return living_end;
        }

        public void setLiving_end(Date living_end) {
            this.living_end = living_end;
        }
    }
}
