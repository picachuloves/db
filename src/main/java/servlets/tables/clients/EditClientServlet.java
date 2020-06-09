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


public class EditClientServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ClientsService service = new ClientsService();
        Clients client = new Clients();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            client = service.getById(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("client", client);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/clients/editClient.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String fio = req.getParameter("fio");
        String phone_number = req.getParameter("phone_number");
        Clients client = new Clients();
        client.setId(id);
        if (!fio.isEmpty()) {
            client.setFio(fio);
        }
        if(!phone_number.isEmpty()) {
            client.setPhone_number(phone_number);
        }
        ClientsService service = new ClientsService();
        try{
            service.update(client);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("clientFio", fio);
        doGet(req,resp);
    }
}
