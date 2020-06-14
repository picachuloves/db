package servlets.tables.bills;

import model.Bills;
import service.BillsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddBillServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/bills/addBill.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_contract = Integer.parseInt(req.getParameter("id_contract"));
        BigDecimal billb = new BigDecimal(req.getParameter("bill"));

        Bills bill = new Bills();
        bill.setId_contract(id_contract);
        bill.setBill(billb);


        BillsService service = new BillsService();
        try{
            service.add(bill);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", bill);
        doGet(req,resp);
    }
}
