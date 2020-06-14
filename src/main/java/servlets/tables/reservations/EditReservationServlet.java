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
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditReservationServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReservationsService service = new ReservationsService();
        Reservations reservation = new Reservations();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            reservation = service.getById(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("reservation", reservation);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/reservations/editReservation.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int res_partner = Integer.parseInt(req.getParameter("res_partner"));
        int stars_number = Integer.parseInt(req.getParameter("stars_number"));
        int floor_number = Integer.parseInt(req.getParameter("floor_number"));
        int discount = Integer.parseInt(req.getParameter("discount"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null, end = null;
        try {
            start = new java.sql.Date(sdf.parse(req.getParameter("res_date_start")).getTime());
            end = new java.sql.Date(sdf.parse(req.getParameter("res_date_end")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Reservations reservation = new Reservations();
        reservation.setRes_partner(res_partner);
        reservation.setStars_number(stars_number);
        reservation.setFloor_number(floor_number);
        reservation.setDiscount(discount);
        reservation.setRes_date_start(start);
        reservation.setRes_date_end(end);
        reservation.setId(id);
        ReservationsService service = new ReservationsService();
        try{
            service.update(reservation);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", reservation);
        doGet(req,resp);
    }
}
