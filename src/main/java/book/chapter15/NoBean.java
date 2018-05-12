package book.chapter15;

import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/nobean"})
public class NoBean extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        
        int id =1;
        String name = "マグロ";
        int price = 100;
        
        out.println(id);
        out.println(":");
        out.println(name);
        out.println(":");
        out.println(price);

        Page.footer(out);
    }
}
