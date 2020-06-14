package servlets.tables.res_rooms;

import model.ResRooms;
import model.Rooms;
import service.ResRoomsService;
import service.RoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditResRoomServlet extends HttpServlet {
    private ResRooms before;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResRoomsService service = new ResRoomsService();
        ResRooms resRoom = new ResRooms();
        String par = req.getParameter("id");
        String[] pars = par.split(";");
        int id_room = Integer.parseInt(pars[0]);
        int id_reservation = Integer.parseInt(pars[1]);
        resRoom.setId_room(id_room);
        resRoom.setId_reservation(id_reservation);
        before = resRoom;
        req.setAttribute("resRoom", resRoom);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/res_rooms/editResRoom.jsp");
        requestDispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        int id_reservation = Integer.parseInt(req.getParameter("id_reservation"));
        ResRooms resRoom = new ResRooms();
        resRoom.setId_room(id_room);
        resRoom.setId_reservation(id_reservation);

        ResRoomsService service = new ResRoomsService();
        try{
            service.update(before, resRoom);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", resRoom);
        doGet(req,resp);
    }
}
