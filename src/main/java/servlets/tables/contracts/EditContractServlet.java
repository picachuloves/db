package servlets.tables.contracts;

import model.Contracts;
import model.Reservations;
import repository.ContractsRepos;
import service.ContractsService;
import service.ReservationsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EditContractServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ContractsService service = new ContractsService();
        Contracts contract = new Contracts();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            contract = service.getByContractNumber(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("contract", contract);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/contracts/editContract.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_client = Integer.parseInt(req.getParameter("id_client"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        int id_reservation = Integer.parseInt(req.getParameter("id_reservation"));

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null, end = null;
        try {
            start = new java.sql.Date(sdf.parse(req.getParameter("living_start")).getTime());
            end = new java.sql.Date(sdf.parse(req.getParameter("living_end")).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Contracts contract = new Contracts();
        contract.setContract_number(id);
        contract.setId_client(id_client);
        contract.setId_room(id_room);
        contract.setLiving_start(start);
        contract.setLiving_end(end);
        contract.setId_reservation(id_reservation);

        ContractsService service = new ContractsService();
        try{
            service.update(contract);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", contract);
        doGet(req,resp);
    }
}
