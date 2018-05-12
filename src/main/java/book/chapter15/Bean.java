package book.chapter15;

import book.bean.Product;
import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/bean"})
public class Bean extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        Product product = new Product();
        product.setId(1);
        product.setName("マグロ");
        product.setPrice(100);

        out.println(product.getId());
        out.println(":");
        out.println(product.getName());
        out.println(":");
        out.println(product.getPrice());

        Page.footer(out);
    }
}
