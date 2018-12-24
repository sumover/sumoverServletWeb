import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class SearchServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Search Service create!");
    }

    @Override
    public void destroy() {
        System.out.println("Search Service destroy!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String Id = req.getParameter("search id");
        PrintWriter printWriter = resp.getWriter();
        try {
            printWriter.println("<h1>Fund success!</h1>");
            printWriter.println("<p>" + FindStudent.getStudentByNumber(Id).toString() + "</p>");
        } catch (NotFindStudent notFindStudent) {
            RequestDispatcher dispatcher = req.getRequestDispatcher("/notFund.html");
            dispatcher.forward(req, resp);
        }
//        RequestDispatcher dispatcher = req.getRequestDispatcher("/FindSuccess.html");
//        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

    }
}
