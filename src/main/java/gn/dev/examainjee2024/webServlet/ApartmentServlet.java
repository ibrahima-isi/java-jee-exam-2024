package gn.dev.examainjee2024.webServlet;

import gn.dev.examainjee2024.dao.ApartmentDAO;
import gn.dev.examainjee2024.dao.interfaces.IApartment;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/apartment/*", "/apartment"}, name = "ApartmentServlet")
public class ApartmentServlet extends HttpServlet {
    private IApartment appartmentDAO;
    @Override
    public void init() throws ServletException {
         appartmentDAO = new ApartmentDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // default page content and charset accepted:
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        /**
         * get the servlet request path
         */
        String path = request.getServletPath();
        if(path.equalsIgnoreCase("/apartment")) {
            request.setAttribute("apartments", appartmentDAO.getAppartments());
            request.getRequestDispatcher("apartments/list.jsp").forward(request, response);
        }

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
