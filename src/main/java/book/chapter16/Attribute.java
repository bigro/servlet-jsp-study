package book.chapter16;

import book.bean.Product;
import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/attribute"})
public class Attribute extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setId(1);
        product.setName("マグロ");
        product.setPrice(100);

        request.setAttribute("product", product);

        request.getRequestDispatcher("attribute.jsp").forward(request, response);
    }
}
