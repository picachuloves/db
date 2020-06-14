package servlets.selects;

import connection.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Select11Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select11.jsp");
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
        String sql = "select partners.contract_number, partners.information from partners inner join reservations on partners.contract_number=reservations.res_partner where reservations.res_date_start>? and reservations.res_date_end<?";
        List<Table> list = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setDate(1, start);
            preparedStatement.setDate(2, end);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Table row = new Table();
                row.setContract_number(resultSet.getInt("contract_number"));
                row.setInformation(resultSet.getString("information"));
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
        private int contract_number;
        private String information;

        public int getContract_number() {
            return contract_number;
        }

        public void setContract_number(int contract_number) {
            this.contract_number = contract_number;
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }
    }
}
