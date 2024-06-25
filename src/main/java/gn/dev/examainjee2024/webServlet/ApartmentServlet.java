package gn.dev.examainjee2024.webServlet;

import gn.dev.examainjee2024.dao.ApartmentDAO;
import gn.dev.examainjee2024.dao.interfaces.IApartment;
import gn.dev.examainjee2024.entity.Apartment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/apartment", "/apartment/add"}, name = "ApartmentServlet")
public class ApartmentServlet extends HttpServlet {
    private final IApartment apartmentDAO = new ApartmentDAO();
    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String path = req.getServletPath();
       if(path.equalsIgnoreCase("/apartment")){
           System.out.println("path : " + path);
           req.setAttribute("apartments", apartmentDAO.getApartments());
           req.getRequestDispatcher("/apartments/list.jsp").forward(req, resp);
       } else if (path.equalsIgnoreCase("/apartment/add")) {
           System.out.println("path : " + path);
           req.getRequestDispatcher("/apartments/form.jsp").forward(req, resp);
       } else {
           System.out.println("Chemin inconnu : " + req.getServletPath() +" "+ req.getPathInfo());
           req.setAttribute("path", path);
           req.getRequestDispatcher("/errors/404.jsp").forward(req, resp);
       }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
