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

public class Select2Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select2.jsp");
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
        int people_number = Integer.parseInt(req.getParameter("people_number"));
        BigDecimal service_cost_per_day = new BigDecimal(req.getParameter("service_cost_per_day"));
        BigDecimal min_price = new BigDecimal(req.getParameter("min_price"));

        List<Table> list =  null;
        try {
            list = doQuery(people_number, service_cost_per_day, min_price, start, end);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }

    private List<Table> doQuery(int people_number, BigDecimal service_cost_per_day, BigDecimal min_price, Date start, Date end) throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select contracts.id_client, fio from rooms inner join contracts on rooms.id=contracts.contract_number inner join clients on rooms.id=clients.id inner join room_types on rooms.id=room_types.id where people_number>? and service_cost_per_day>? and min_price>? and living_start>? and living_end<?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, people_number);
            preparedStatement.setBigDecimal(2, service_cost_per_day);
            preparedStatement.setBigDecimal(3, min_price);
            preparedStatement.setDate(4, start);
            preparedStatement.setDate(5, end);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Table row = new Table();
                row.setId_client(resultSet.getInt("id_client"));
                row.setFio(resultSet.getString("fio"));
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
        public int getId_client() {
            return id_client;
        }

        public void setId_client(int id_client) {
            this.id_client = id_client;
        }

        public String getFio() {
            return fio;
        }

        public void setFio(String fio) {
            this.fio = fio;
        }

        private int id_client;
        private String fio;
    }
}
