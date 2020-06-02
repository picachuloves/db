package servlets;

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
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/clients.jsp");
        requestDispatcher.forward(req, resp);
    }
}
