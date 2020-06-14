package servlets.tables.bills;

import model.Bills;
import model.Contracts;
import model.Reviews;
import service.BillsService;
import service.ContractsService;
import service.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditBillServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BillsService service = new BillsService();
        Bills bill = new Bills();

        id = Integer.parseInt(req.getParameter("id"));
        try {
            bill = service.getByBillNumber(id);
        }catch (SQLException ex){
            ex.printStackTrace();
        }

        req.setAttribute("bill", bill);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/bills/editBill.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_contract = Integer.parseInt(req.getParameter("id_contract"));
        BigDecimal billb = new BigDecimal(req.getParameter("bill"));

        Bills bill = new Bills();
        bill.setBill_number(id);
        bill.setId_contract(id_contract);
        bill.setBill(billb);


        BillsService service = new BillsService();
        try{
            service.update(bill);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", bill);
        doGet(req,resp);
    }
}
