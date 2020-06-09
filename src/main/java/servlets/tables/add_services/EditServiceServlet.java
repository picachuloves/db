package servlets.tables.add_services;

import model.AddServices;
import model.Partners;
import service.AddServicesService;
import service.PartnersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class EditServiceServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AddServicesService service = new AddServicesService();
        AddServices aservice = new AddServices();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            aservice = service.getById(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("aservice", aservice);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/add_services/editService.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String services = req.getParameter("services");
        BigDecimal services_allowance = new BigDecimal(req.getParameter("services_allowance"));
        String food = req.getParameter("food");
        BigDecimal food_allowance = new BigDecimal(req.getParameter("food_allowance"));
        String entertainments = req.getParameter("entertainments");
        BigDecimal entertainments_allowance = new BigDecimal(req.getParameter("entertainments_allowance"));
        AddServices aservice = new AddServices();
        aservice.setServices(services);
        aservice.setServices_allowance(services_allowance);
        aservice.setFood(food);
        aservice.setFood_allowance(food_allowance);
        aservice.setEntertainments(entertainments);
        aservice.setEntertainments_allowance(entertainments_allowance);
        aservice.setId(id);
        AddServicesService service = new AddServicesService();
        try{
            service.update(aservice);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", aservice);
        doGet(req,resp);
    }
}
