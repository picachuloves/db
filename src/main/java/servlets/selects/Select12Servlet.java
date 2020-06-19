package servlets.selects;

import connection.DBConnection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Select12Servlet extends HttpServlet {
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select12.jsp");
        requestDispatcher.forward(req, resp);
    }

    private List<Table> doQuery() throws SQLException{
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select clients.id, clients.fio, COUNT(*) as \"Count visiting\" from clients right join contracts on clients.id=contracts.id_client group by clients.id order by \"Count visiting\" DESC;\n";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setFio(resultSet.getString("fio"));
                row.setCount(resultSet.getInt("Count visiting"));
                list.add(row);
            }
        } catch (SQLException ex) {
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
        private String fio;
        private int count;

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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }
}
