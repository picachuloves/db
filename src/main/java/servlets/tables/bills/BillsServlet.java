package servlets.tables.bills;

import model.Bills;
import model.Reviews;
import service.BillsService;
import service.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BillsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BillsService service = new BillsService();
        List<Bills> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/bills/bills.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BillsService service = new BillsService();
        Bills bill = new Bills();
        try {
            if (request.getParameter("delete") != null) {
                int bill_number = Integer.parseInt(request.getParameter("delete"));

                bill.setBill_number(bill_number);
                service.remove(bill);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Bills> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/bills/bills.jsp");
        requestDispatcher.forward(request, response);
    }
}
