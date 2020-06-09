package servlets.tables.partners;

import model.Clients;
import model.Partners;
import service.ClientsService;
import service.PartnersService;

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

public class EditPartnerServlet extends HttpServlet {
    private int id;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PartnersService service = new PartnersService();
        Partners partner = new Partners();
        try {
            id = Integer.parseInt((String)req.getParameter("id"));
            partner = service.getByContractNumber(id);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("partner", partner);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/partners/editPartner.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String information = req.getParameter("information");
        Partners partner = new Partners();

        partner.setContract_number(id);
        if (!information.isEmpty()) {
            partner.setInformation(information);
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null, end = null;
        try {
            if(!req.getParameter("start").isEmpty()) {
                start = new java.sql.Date(sdf.parse(req.getParameter("start")).getTime());
                partner.setCooperation_date_start(start);
            }
            if(!req.getParameter("end").isEmpty()) {
                end = new java.sql.Date(sdf.parse(req.getParameter("end")).getTime());
                partner.setCooperation_date_end(end);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        PartnersService service = new PartnersService();
        try{
            service.update(partner);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", information);
        doGet(req,resp);
    }
}
