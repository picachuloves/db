package servlets.selects;

import model.Contracts;
import service.ContractsService;

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

public class Select6Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select6.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = new java.sql.Date(sdf.parse(req.getParameter("date")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        List<Contracts> list = new ArrayList<>();
        ContractsService service = new ContractsService();
        try {
            list = service.getWillFreeByDate(date);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        doGet(req,resp);
    }
}
