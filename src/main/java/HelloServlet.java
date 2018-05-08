import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Servlet/JSP Sample Programs</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p>Hello!</p>");
        out.println("<p>こんにちは!</p>");
        out.println("<p>" + LocalDate.now() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
