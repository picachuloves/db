package servlets.tables.res_clients;

import model.ResClients;
import model.ResRooms;
import service.ResClientsService;
import service.ResRoomsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditResClientServlet extends HttpServlet {
    private ResClients before;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResRoomsService service = new ResRoomsService();
        ResClients resClient = new ResClients();
        String par = req.getParameter("id");
        String[] pars = par.split(";");
        int id_client = Integer.parseInt(pars[0]);
        int id_reservation = Integer.parseInt(pars[1]);
        resClient.setId_client(id_client);
        resClient.setId_reservation(id_reservation);
        before = resClient;
        req.setAttribute("resClient", resClient);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/res_clients/editResClient.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_client = Integer.parseInt(req.getParameter("id_client"));
        int id_reservation = Integer.parseInt(req.getParameter("id_reservation"));
        ResClients resClient = new ResClients();
        resClient.setId_client(id_client);
        resClient.setId_reservation(id_reservation);

        ResClientsService service = new ResClientsService();
        try{
            service.update(before, resClient);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", resClient);
        doGet(req,resp);
    }
}
