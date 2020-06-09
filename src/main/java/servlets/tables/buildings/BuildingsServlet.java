package servlets.tables.buildings;

import model.AddServices;
import model.Buildings;
import service.AddServicesService;
import service.BuildingsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class BuildingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BuildingsService service = new BuildingsService();
        List<Buildings> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/buildings/buildings.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BuildingsService service = new BuildingsService();
        Buildings building = new Buildings();
        try {
            if (request.getParameter("delete") != null) {
                int delete = Integer.parseInt(request.getParameter("delete"));
                building.setId(delete);
                service.remove(building);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Buildings> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/buildings/buildings.jsp");
        requestDispatcher.forward(request, response);
    }
}
