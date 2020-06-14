package servlets.tables.reviews;

import model.ResClients;
import model.Reviews;
import service.ResRoomsService;
import service.ReviewsService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class EditReviewServlet extends HttpServlet {
    private Reviews before;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ReviewsService service = new ReviewsService();
        Reviews review = new Reviews();

        String par = req.getParameter("id");
        String[] pars = par.split(";");
        int id_client = Integer.parseInt(pars[0]);
        int id_room = Integer.parseInt(pars[1]);
        try {
            review = service.get(id_client, id_room);
        }catch (SQLException ex){
            ex.printStackTrace();
        }
        before = review;

        req.setAttribute("review", review);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/tables/reviews/editReview.jsp");
        requestDispatcher.forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        int id_client = Integer.parseInt(req.getParameter("id_client"));
        int id_room = Integer.parseInt(req.getParameter("id_room"));
        int mark = Integer.parseInt(req.getParameter("mark"));
        String reviewstr = req.getParameter("review");

        Reviews review = new Reviews();
        review.setId_client(id_client);
        review.setId_room(id_room);
        review.setMark(mark);
        review.setReview(reviewstr);

        ReviewsService service = new ReviewsService();
        try{
            service.update(before, review);
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        req.setAttribute("answer", review);
        doGet(req,resp);
    }
}
