package servlets.tables.reviews;

import model.Partners;
import model.Reviews;
import service.PartnersService;
import service.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class ReviewsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewsService service = new ReviewsService();
        List<Reviews> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("list", list);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/reviews/reviews.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ReviewsService service = new ReviewsService();
        Reviews review = new Reviews();
        try {
            if (request.getParameter("delete") != null) {
                String par = request.getParameter("delete");
                String[] pars = par.split(";");
                int id_client = Integer.parseInt(pars[0]);
                int id_room = Integer.parseInt(pars[1]);

                review.setId_client(id_client);
                review.setId_room(id_room);
                service.remove(review);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        List<Reviews> list = null;
        try {
            list = service.getAll();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        request.setAttribute("list", list);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/tables/reviews/reviews.jsp");
        requestDispatcher.forward(request, response);
    }
}
