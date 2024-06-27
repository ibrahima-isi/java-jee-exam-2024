package gn.dev.examainjee2024.webServlet;

import gn.dev.examainjee2024.dao.UserDAO;
import gn.dev.examainjee2024.dao.interfaces.IUser;
import gn.dev.examainjee2024.entity.Role;
import gn.dev.examainjee2024.entity.User;
import gn.dev.examainjee2024.webServlet.models.UserModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/user/*", name = "UserServlet")
public class UserServlet extends HttpServlet {
    private final IUser userDAO = new UserDAO();

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("UserServlet initialized");
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getRequestURI();

        if (path.equalsIgnoreCase("/user/list")) {
            System.out.println("Entering /user/list block");
            System.out.println("path : " + path);

            UserModel userModel = new UserModel();
            userModel.setUsers(userDAO.getUsers());
            req.setAttribute("users", userModel);
            req.getRequestDispatcher("/utilisateurs/list.jsp").forward(req, resp);
        }
        else if (path.equalsIgnoreCase("/user/details")) {
            System.out.println("Entering /user/details block");
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
                } catch (NumberFormatException e) {
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                }

            }
        }
        else if (path.equalsIgnoreCase("/user/create")) {
            System.out.println("Entering /user/create block");

            System.out.println("path : " + path);

            req.getRequestDispatcher("/utilisateurs/form.jsp").forward(req, resp);
        }
        else if(path.equalsIgnoreCase("/user/edit")) {
            System.out.println("Entering /user/edit block");
            System.out.println("path : " + path);
            req.getRequestDispatcher("/utilisateurs/edit.jsp").forward(req, resp);

        }
        else if (path.equalsIgnoreCase("/user/delete")) {
            System.out.println("Entering /user/delete block");
            System.out.printf("path : " + path);

            String idParam = req.getParameter("id");
            if (idParam != null) {
                try {
                    userDAO.deleteUser(Integer.parseInt(idParam));
                } catch (Exception e) {
                    System.out.println("Error sur l'id : " + e);
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                }
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
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
        String path = req.getPathInfo();

        if (path.equalsIgnoreCase("/store") && req.getMethod().equalsIgnoreCase("POST")) {
            System.out.println("Entering /user/store block");

            String firstName = req.getParameter("name");
            String email = req.getParameter("email");
            String password = req.getParameter("password");

            User user = new User();
            user.setUserName(firstName);
            user.setUserEmail(email);
            user.setUserPassword(password);
            user.setStatus(true);
            try {
                // saving the user to the database
                userDAO.addUser(user);
                resp.sendRedirect("/user/list");
            } catch (Exception e) {
                System.out.println("Error saving user : " + e);
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
            }
        }
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();

        if (path.equalsIgnoreCase("/update") && req.getMethod().equalsIgnoreCase("PUT")) {
            System.out.println("Entering /user/update block");

            String idParam = req.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int userId = Integer.parseInt(idParam);
                    User user = userDAO.getUserById(userId);

                    String firstName = req.getParameter("name");
                    String email = req.getParameter("email");
                    String password = req.getParameter("password");
                    boolean status = Boolean.parseBoolean(req.getParameter("status"));
                    int role_id = Integer.parseInt(req.getParameter("role_id"));
                    Role role = new Role();
                    role.setId(role_id);


                    System.out.println(userId);
                    System.out.println(user);
                    System.out.println(firstName);
                    System.out.println(email);
                    System.out.println(password);
                    System.out.println(status);

                    user.setUserName(firstName);
                    user.setUserEmail(email);
                    user.setUserPassword(password);
                    user.setStatus(status);
                    user.setRole(role);

                    userDAO.updateUser(user);
                    resp.sendRedirect("/user/list");
                } catch (Exception e) {
                    System.out.println("Error sur l'id : " + e);
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                }
            }
        }
    }

    /**
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        System.out.println("Chemin courant : " + path);

        if (path.equalsIgnoreCase("/delete") && req.getMethod().equalsIgnoreCase("DELETE")) {
            System.out.println("Entering /user/delete block");

            String idParam = req.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                try {
                    int userId = Integer.parseInt(idParam);
                    userDAO.deleteUser(userId);
                } catch (Exception e) {
                    System.out.println("Error sur l'id : " + e);
                    resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid user ID format");
                }
            } else {
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing user ID");
            }
            resp.sendRedirect("/user/list");
        }
    }
}
