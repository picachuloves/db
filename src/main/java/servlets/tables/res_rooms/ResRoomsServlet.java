package servlets.tables.res_rooms;

import model.ResRooms;
import service.ResRoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class ResRoomsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResRoomsService service = new ResRoomsService();
        List<ResRooms> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/res_rooms/resRooms.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResRoomsService service = new ResRoomsService();
        ResRooms resRoom = new ResRooms();
        try {
            if (request.getParameter("delete") != null) {
                String par = request.getParameter("delete");
                String[] pars = par.split(";");
                int id_rooom = Integer.parseInt(pars[0]);
                int id_reservation = Integer.parseInt(pars[1]);

                resRoom.setId_room(id_rooom);
                resRoom.setId_reservation(id_reservation);
                service.remove(resRoom);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<ResRooms> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/res_rooms/resRooms.jsp");
        requestDispatcher.forward(request, response);
    }
}
