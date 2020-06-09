package servlets.tables.reservations;

import model.Partners;
import model.Reservations;
import service.PartnersService;
import service.ReservationsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReservationsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationsService service = new ReservationsService();
        List<Reservations> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/reservations/reservations.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReservationsService service = new ReservationsService();
        Reservations reservation = new Reservations();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                reservation.setId(delete);
                service.remove(reservation);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Reservations> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/reservations/reservations.jsp");
        requestDispatcher.forward(request, response);
    }
}
