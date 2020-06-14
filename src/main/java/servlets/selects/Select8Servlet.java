package servlets.selects;

import connection.DBConnection;
import model.Reviews;
import service.ReviewsService;

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

public class Select8Servlet extends HttpServlet {
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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select8.jsp");
        requestDispatcher.forward(req, resp);
    }
    private List<Table> doQuery() throws SQLException{
        Connection connection = DBConnection.getConnection();
        List<Table> list = new ArrayList<>();
        String sql = "select clients.id, clients.fio, reviews.mark, reviews.review from clients inner join reviews on reviews.id_client=clients.id where reviews.mark<3;";
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Table row = new Table();
                row.setId(resultSet.getInt("id"));
                row.setFio(resultSet.getString("fio"));
                row.setMark(resultSet.getInt("mark"));
                row.setReview(resultSet.getString("review"));
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
        private int mark;

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

        public int getMark() {
            return mark;
        }

        public void setMark(int mark) {
            this.mark = mark;
        }

        public String getReview() {
            return review;
        }

        public void setReview(String review) {
            this.review = review;
        }

        private String review;
    }
}
