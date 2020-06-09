package servlets.tables.room_types;

import model.Buildings;
import model.RoomTypes;
import service.BuildingsService;
import service.RoomTypesService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class RoomTypesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomTypesService service = new RoomTypesService();
        List<RoomTypes> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/room_types/roomtypes.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RoomTypesService service = new RoomTypesService();
        RoomTypes roomType = new RoomTypes();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                roomType.setId(delete);
                service.remove(roomType);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<RoomTypes> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/room_types/roomtypes.jsp");
        requestDispatcher.forward(request, response);
    }
}
