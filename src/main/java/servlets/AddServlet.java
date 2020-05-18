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

public class AddServlet extends HttpServlet {
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/add.jsp");
       requestDispatcher.forward(req, resp);
   }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fio = req.getParameter("fio");
        String phone_number = req.getParameter("phone_number");
        Clients client = new Clients();
        client.setFio(fio);
        client.setPhone_number(phone_number);
        ClientsService service = new ClientsService();
        try{
            service.add(client);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("clientFio", fio);
        doGet(req,resp);
    }
}
