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


public class Select1Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select1.jsp");
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
        int count = Integer.parseInt(req.getParameter("count"));
        List<Table> list =  null;
        try {
            list = doQuery(start, end, count);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }

    private List<Table> doQuery(Date start, Date end, int count) throws SQLException {
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sqlall = "SELECT contract_number,information, COUNT(*) as \"Clients number\" FROM partners INNER JOIN reservations ON partners.contract_number=reservations.res_partner AND reservations.res_date_start>? AND reservations.res_date_end<? INNER JOIN res_clients ON res_clients.id_reservation=reservations.id GROUP BY contract_number HAVING COUNT(*)>?";
        String sql = "SELECT contract_number,information, COUNT(*) as \"Clients number\" FROM partners INNER JOIN reservations ON partners.contract_number=reservations.res_partner INNER JOIN res_clients ON res_clients.id_reservation=reservations.id GROUP BY contract_number HAVING COUNT(*)>?";

        PreparedStatement preparedStatement = null;
        try{
            ResultSet resultSet = null;
            if(start!=null && end!=null)
            {
                preparedStatement = connection.prepareStatement(sqlall);
                preparedStatement.setDate(1, start);
                preparedStatement.setDate(2, end);
                preparedStatement.setInt(3, count);

            } else {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, count);
            }

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Table row = new Table();
                row.setContract_number(resultSet.getInt("contract_number"));
                row.setInformation(resultSet.getString("information"));
                row.setCount(resultSet.getInt("Clients number"));

                list.add(row);
            }

            }catch (SQLException ex){
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
        private int count;

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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
