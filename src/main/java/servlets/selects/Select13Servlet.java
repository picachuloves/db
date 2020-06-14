package servlets.selects;

import model.Clients;
import service.ClientsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Select13Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select13.jsp");
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
        ClientsService service = new ClientsService();
        List<Clients> list = new ArrayList<>();
        try {
            list = service.getNewByDate(start, end);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }
}
