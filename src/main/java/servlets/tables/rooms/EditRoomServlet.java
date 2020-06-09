package servlets.tables.rooms;

import model.RoomTypes;
import model.Rooms;
import service.RoomTypesService;
import service.RoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditRoomServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RoomsService service = new RoomsService();
        Rooms room = new Rooms();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            room = service.getById(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("room", room);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/rooms/editRoom.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_building = Integer.parseInt(req.getParameter("id_building"));
        int id_room_types = Integer.parseInt(req.getParameter("id_room_types"));
        Rooms room = new Rooms();
        room.setId_building(id_building);
        room.setId_room_types(id_room_types);
        room.setId(id);
        RoomsService service = new RoomsService();
        try{
            service.update(room);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", id_building);
        doGet(req,resp);
    }
}
