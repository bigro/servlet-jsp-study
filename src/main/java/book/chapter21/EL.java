package book.chapter21;

import book.bean.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/chapter21/el"})
public class EL extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Product product = new Product();
        product.setId(1);
        product.setName("マグロ");
        product.setPrice(100);

        request.setAttribute("product", product);

        request.getRequestDispatcher("el.jsp").forward(request, response);
    }
}
