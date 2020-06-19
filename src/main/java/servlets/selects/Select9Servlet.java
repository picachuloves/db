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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Select9Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select9.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null, end = null;
        try {
            start = new java.sql.Date(sdf.parse(req.getParameter("start")).getTime());
            end = new java.sql.Date(sdf.parse(req.getParameter("end")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Table> list = new ArrayList<>();
        try {
            list = doQuery(start, end);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }

    private List<Table> doQuery(Date start, Date end) throws SQLException{
        Connection connection = DBConnection.getConnection();
        String sql = "select rooms.id, bill/service_cost_per_day as \"Rent\" from rooms inner join contracts on rooms.id=contracts.id_room inner join bills on contract_number=id_contract inner join room_types on room_types.id=id_room_types where living_start>? and living_end<? order by \"Rent\" DESC";
        List<Table> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, start);
            preparedStatement.setDate(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setRent(resultSet.getBigDecimal("Rent"));
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
        private BigDecimal rent;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public BigDecimal getRent() {
            return rent;
        }

        public void setRent(BigDecimal rent) {
            this.rent = rent;
        }
    }
}
