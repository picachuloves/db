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
import java.util.List;

public class ResClientsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ResClientsService service = new ResClientsService();
        List<ResClients> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/res_clients/resClients.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ResClientsService service = new ResClientsService();
        ResClients resClient = new ResClients();
        try {
            if (request.getParameter("delete") != null) {
                String par = request.getParameter("delete");
                String[] pars = par.split(";");
                int id_client = Integer.parseInt(pars[0]);
                int id_reservation = Integer.parseInt(pars[1]);

                resClient.setId_client(id_client);
                resClient.setId_reservation(id_reservation);
                service.remove(resClient);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<ResClients> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/res_clients/resClients.jsp");
        requestDispatcher.forward(request, response);
    }
}
