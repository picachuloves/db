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

public class Select5Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Table> list = null;
        try {
            list = doQuery();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select5.jsp");
        requestDispatcher.forward(req, resp);
    }

    private List<Table> doQuery() throws SQLException{
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select rooms.id, living_start, floor, people_number, service_cost_per_day, min_price from rooms  join contracts on rooms.id = contracts.id_room join room_types on rooms.id_room_types=room_types.id where (living_start>current_date)";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setLiving_start(resultSet.getDate("living_start"));
                row.setFloor(resultSet.getInt("floor"));
                row.setPeople_number(resultSet.getInt("people_number"));
                row.setService_cost_per_day(resultSet.getBigDecimal("service_cost_per_day"));
                row.setMin_price(resultSet.getBigDecimal("min_price"));
                list.add(row);
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }


    public class Table{
        private int id;
        private Date living_start;
        private int floor;
        private int people_number;
        private BigDecimal service_cost_per_day;
        private BigDecimal min_price;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Date getLiving_start() {
            return living_start;
        }

        public void setLiving_start(Date living_start) {
            this.living_start = living_start;
        }

        public int getFloor() {
            return floor;
        }

        public void setFloor(int floor) {
            this.floor = floor;
        }

        public int getPeople_number() {
            return people_number;
        }

        public void setPeople_number(int people_number) {
            this.people_number = people_number;
        }

        public BigDecimal getService_cost_per_day() {
            return service_cost_per_day;
        }

        public void setService_cost_per_day(BigDecimal service_cost_per_day) {
            this.service_cost_per_day = service_cost_per_day;
        }

        public BigDecimal getMin_price() {
            return min_price;
        }

        public void setMin_price(BigDecimal min_price) {
            this.min_price = min_price;
        }
    }
}
