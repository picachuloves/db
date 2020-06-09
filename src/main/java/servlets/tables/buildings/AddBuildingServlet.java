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
import java.math.BigDecimal;
import java.sql.SQLException;

public class AddBuildingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/buildings/addBuilding.jsp");
        requestDispatcher.forward(req, resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int stars_number = Integer.parseInt(req.getParameter("stars_number"));
        int floors_number = Integer.parseInt(req.getParameter("floors_number"));
        int rooms_number = Integer.parseInt(req.getParameter("rooms_number"));
        int rooms_per_floor_number = Integer.parseInt(req.getParameter("rooms_per_floor_number"));
        BigDecimal building_min_price = new BigDecimal(req.getParameter("building_min_price"));
        int id_add_services = Integer.parseInt(req.getParameter("id_add_services"));
        Buildings building = new Buildings();
        building.setStars_number(stars_number);
        building.setFloors_number(floors_number);
        building.setRooms_number(rooms_number);
        building.setRooms_per_floor_number(rooms_per_floor_number);
        building.setBuilding_min_price(building_min_price);
        building.setId_add_services(id_add_services);

        BuildingsService service = new BuildingsService();
        try{
            service.add(building);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", building);
        doGet(req,resp);
    }
}
