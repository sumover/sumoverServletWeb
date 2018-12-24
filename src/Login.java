import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<h1>login Success!</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/loginSuccess.html");
        dispatcher.forward(req, resp);
    }

    @Override
    public void destroy() {
        System.out.println("Login service destroy!");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Login service create!");
    }
}
