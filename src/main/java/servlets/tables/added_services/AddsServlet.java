package servlets.tables.added_services;

import model.AddedServices;
import model.Bills;
import service.AddedServicesService;
import service.BillsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class AddsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddedServicesService service = new AddedServicesService();
        List<AddedServices> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/adds/adds.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AddedServicesService service = new AddedServicesService();
        AddedServices add = new AddedServices();
        try {
            if (request.getParameter("delete") != null) {
                int id = Integer.parseInt(request.getParameter("delete"));

                add.setId(id);
                service.removeById(add);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<AddedServices> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/adds/adds.jsp");
        requestDispatcher.forward(request, response);
    }
}
