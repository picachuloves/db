package servlets.tables.clients;

import model.Clients;
import service.ClientsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ClientsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientsService service = new ClientsService();
        List<Clients> clients = null;
        try {
            clients = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("clientslist", clients);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/clients/clients.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ClientsService service = new ClientsService();
        Clients client = new Clients();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                client.setId(delete);
                service.remove(client);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Clients> clients = null;
        try {
            clients = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("clientslist", clients);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/clients/clients.jsp");
        requestDispatcher.forward(request, response);
    }
}
