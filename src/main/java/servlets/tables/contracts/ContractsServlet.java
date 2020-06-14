package servlets.tables.contracts;

import model.Contracts;
import model.Reviews;
import service.ContractsService;
import service.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ContractsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractsService service = new ContractsService();
        List<Contracts> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/contracts/contracts.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ContractsService service = new ContractsService();
        Contracts contract = new Contracts();
        try {
            if (request.getParameter("delete") != null) {
                int contract_number = Integer.parseInt(request.getParameter("delete"));

                contract.setContract_number(contract_number);
                service.remove(contract);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Contracts> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/contracts/contracts.jsp");
        requestDispatcher.forward(request, response);
    }
}
