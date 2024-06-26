package gn.dev.examainjee2024.webServlet;

import gn.dev.examainjee2024.dao.UserDAO;
import gn.dev.examainjee2024.dao.interfaces.IUser;
import gn.dev.examainjee2024.entity.User;
import gn.dev.examainjee2024.webServlet.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = {"/user", "/users", "/user/add", "/user/delete"})
public class UserServlet extends HttpServlet {
    private final IUser userDAO = new UserDAO();


    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equalsIgnoreCase("/users")) {
            System.out.println("path : " + path);

            UserModel userModel = new UserModel();
            userModel.setUsers(userDAO.getUsers());
            req.setAttribute("users", userModel);
            req.getRequestDispatcher("/utilisateurs/list.jsp").forward(req, resp);
        }
        else if (path.equalsIgnoreCase("/user")) {
            System.out.println("path : " + path);

            // handling the id = null
            String idParam = req.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int userId = Integer.parseInt(idParam);
                    User user = userDAO.getUserById(userId);

                    System.out.println(user);

                    req.setAttribute("user", user);
                    req.getRequestDispatcher("/utilisateurs/details.jsp").forward(req, resp);
                }
                catch (NumberFormatException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                }

            }
        }
            else if (path.equalsIgnoreCase("/user/add")) {
                System.out.println("path : " + path);

                req.getRequestDispatcher("/utilisateurs/form.jsp").forward(req, resp);
            } else if (path.equalsIgnoreCase("/user/delete")) {
                System.out.printf("path : " + path);

                String idParam = req.getParameter("id");
                if(idParam != null) {
                    try {
                        userDAO.deleteUser(Integer.parseInt(idParam));
                    } catch (Exception e) {
                        System.out.println("Error sur l'id : " + e);
                        resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                    }
                }
                req.getRequestDispatcher("/utilisateurs/list.jsp").forward(req, resp);
            }

        }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }
}
