package book;

import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

@WebServlet(urlPatterns = {"/control"})
public class Control extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");

        Page.header(out);

        ArrayList<String> names = Collections.list(request.getParameterNames());

        for (String name : names) {
            String[] values = request.getParameterValues(name);
            for (String value : values) {
                out.println("<p>" + name + "=" + value + "</p>");
            }
        }
        
        Page.footer(out);
    }
}
