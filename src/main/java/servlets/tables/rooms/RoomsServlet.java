package servlets.tables.rooms;

import model.Rooms;
import service.RoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomsService service = new RoomsService();
        List<Rooms> free = null;
        int freecount = 0;
        int rescount = 0;
        List<Rooms> list = null;
        try {
            free = service.getFreeRooms();
            freecount = free.size();
            list = service.getAll();
            rescount = service.getReservedRoomsCount();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        float res = (float)rescount/(float)list.size() * 100;
        req.setAttribute("freecount", freecount);
        req.setAttribute("rescount", res);
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/rooms/rooms.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomsService service = new RoomsService();
        Rooms room = new Rooms();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                room.setId(delete);
                service.remove(room);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Rooms> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/rooms/rooms.jsp");
        requestDispatcher.forward(request, response);
    }
}
