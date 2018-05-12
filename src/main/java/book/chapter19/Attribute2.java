package book.chapter19;

import tool.Page;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Properties;

@WebServlet(urlPatterns = {"/chapter19/attribute2"})
public class Attribute2 extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        ServletContext context = getServletContext();
        ArrayList<String> list = Collections.list(context.getAttributeNames());
        for (String name : list) {
            out.println("<p>" + name + " : ");
            out.println(context.getAttribute(name));
            out.println("</p>");
        }
        
        Page.footer(out);
    }
}
