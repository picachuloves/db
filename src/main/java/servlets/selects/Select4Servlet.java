package servlets.selects;

import model.Rooms;
import service.RoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Select4Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/selects/select4.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int people_number = Integer.parseInt(req.getParameter("people_number"));
        BigDecimal service_cost_per_day = new BigDecimal(req.getParameter("service_cost_per_day"));
        BigDecimal min_price = new BigDecimal(req.getParameter("min_price"));
        RoomsService service = new RoomsService();
        List<Rooms> list = new ArrayList<>();
        try {
            list = service.getFreeRooms(people_number, service_cost_per_day, min_price);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("count", list.size());
        doGet(req,resp);
    }

}
