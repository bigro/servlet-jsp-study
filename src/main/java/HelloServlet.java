import tool.Page;

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

        Page.header(out);
        
        out.println("<p>Hello!</p>");
        out.println("<p>こんにちは!!!!!!</p>");
        out.println("<p>" + LocalDate.now() + "</p>");

        Page.footer(out);
    }
}
