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
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddAddServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/adds/addAdd.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int bill_number = Integer.parseInt(req.getParameter("bill_number"));
        String add_service = req.getParameter("add_service");
        BigDecimal service_bill = new BigDecimal(req.getParameter("service_bill"));

        AddedServices add = new AddedServices();
        add.setBill_number(bill_number);
        add.setAdd_service(add_service);
        add.setService_bill(service_bill);

        AddedServicesService service = new AddedServicesService();
        try{
            service.add(add);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", add);
        doGet(req,resp);
    }
}
