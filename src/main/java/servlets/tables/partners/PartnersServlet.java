package servlets.tables.partners;

import model.Partners;
import service.PartnersService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class PartnersServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PartnersService service = new PartnersService();
        List<Partners> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/partners/partners.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PartnersService service = new PartnersService();
        Partners partner = new Partners();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                partner.setContract_number(delete);
                service.remove(partner);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Partners> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/partners/partners.jsp");
        requestDispatcher.forward(request, response);
    }
}
