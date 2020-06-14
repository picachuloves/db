package servlets.tables.res_clients;

import model.ResClients;
import service.ResClientsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class AddResClientServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/res_clients/addResClient.jsp");
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
            service.add(resClient);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", resClient);
        doGet(req,resp);
    }
}
