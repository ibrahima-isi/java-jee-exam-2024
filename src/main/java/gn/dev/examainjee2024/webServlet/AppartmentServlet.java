package gn.dev.examainjee2024.webServlet;

import gn.dev.examainjee2024.dao.AppartmentDAO;
import gn.dev.examainjee2024.dao.interfaces.IAppartment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/appartment", name = "AppartmentServlet")
public class AppartmentServlet extends HttpServlet {
    private IAppartment appartmentDAO;
    @Override
    public void init() throws ServletException {
         appartmentDAO = new AppartmentDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("appartements", appartmentDAO.getAppartments());
        request.getRequestDispatcher("appartments/list.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public void destroy() {
        appartmentDAO = null;
    }
}
