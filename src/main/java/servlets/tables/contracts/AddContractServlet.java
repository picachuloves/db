package servlets.tables.contracts;

import model.Clients;
import model.Contracts;
import model.Reservations;
import model.Rooms;
import service.ClientsService;
import service.ContractsService;
import service.ReservationsService;
import service.RoomsService;

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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class AddContractServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime now = LocalDateTime.now();
        req.setAttribute("today", dtf.format(now));

        ClientsService clientsService = new ClientsService();
        RoomsService roomsService = new RoomsService();
        ReservationsService reservationsService = new ReservationsService();
        List<Clients> clients = null;
        List<Rooms> rooms = null;
        List<Reservations> reservations = null;
        try {
            clients = clientsService.getAll();
            rooms = roomsService.getFreeRooms();
            reservations = reservationsService.getAvailableRes();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("clients", clients);
        req.setAttribute("rooms", rooms);
        req.setAttribute("reservations", reservations);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/contracts/addContract.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_client = Integer.parseInt(req.getParameter("id_client"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        int id_reservation = Integer.parseInt(req.getParameter("id_reservation"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null, end = null;
        try {
            start = new java.sql.Date(sdf.parse(req.getParameter("living_start")).getTime());
            end = new java.sql.Date(sdf.parse(req.getParameter("living_end")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Contracts contract = new Contracts();
        contract.setId_client(id_client);
        contract.setId_room(id_room);
        contract.setLiving_start(start);
        contract.setLiving_end(end);
        contract.setId_reservation(id_reservation);


        ContractsService service = new ContractsService();
        try{
            service.add(contract);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", contract);
        doGet(req,resp);
    }
}
