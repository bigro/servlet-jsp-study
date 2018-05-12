package book.chapter17;

import book.bean.Product;
import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = {"/cart-get"})
public class CartGet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        HttpSession session = request.getSession();

        List<Product> cart = (List<Product>) session.getAttribute("cart");

        for (Product product : cart) {
            out.println("<p>");
            out.println(product.getName());
            out.println(":");
            out.println(product.getPrice());
            out.println("</p>");
        }
        
        Page.footer(out);
    }
}
