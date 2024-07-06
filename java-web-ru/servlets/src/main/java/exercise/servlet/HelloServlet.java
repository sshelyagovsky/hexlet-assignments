package exercise.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "HelloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    // BEGIN
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/plain");
        String name = req.getParameter("name");
        String message = "Hello, ";
//        if (name != null) {
//            res.getWriter().write(message + name + "!");
//        } else {
//            res.getWriter().write(message + "Guest!");
//        }
        if (name != null) {
            message = message + name + "!";
        } else {
            message = message + "Guest!";
        }
        req.setAttribute("message", message);
        req.getRequestDispatcher("/WEB-INF/hello.jsp").forward(req, res);
    }
    // END
}
