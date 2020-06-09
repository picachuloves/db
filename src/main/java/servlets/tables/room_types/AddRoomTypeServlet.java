package servlets.tables.room_types;

import model.RoomTypes;
import service.RoomTypesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddRoomTypeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/room_types/addRoomType.jsp");
        requestDispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int floor = Integer.parseInt(req.getParameter("floor"));
        int people_number = Integer.parseInt(req.getParameter("people_number"));
        BigDecimal service_cost_per_day = new BigDecimal(req.getParameter("service_cost_per_day"));
        BigDecimal min_price = new BigDecimal(req.getParameter("min_price"));
        RoomTypes roomtype = new RoomTypes();
        roomtype.setFloor(floor);
        roomtype.setPeople_number(people_number);
        roomtype.setService_cost_per_day(service_cost_per_day);
        roomtype.setMin_price(min_price);

        RoomTypesService service = new RoomTypesService();
        try{
            service.add(roomtype);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", roomtype);
        doGet(req,resp);
    }
}
