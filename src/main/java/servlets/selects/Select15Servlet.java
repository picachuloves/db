package servlets.selects;

import connection.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Select15Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select15.jsp");
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
        String sql = "select clients.id, clients.fio,contracts.living_start, contracts.living_end  from clients inner join contracts on clients.id=contracts.contract_number inner join rooms on rooms.id=contracts.id_room and rooms.id=?;";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id_room);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setFio(resultSet.getString("fio"));
                row.setLiving_start(resultSet.getDate("living_start"));
                row.setLiving_end(resultSet.getDate("living_end"));
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
        private Date living_start;
        private Date living_end;

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
