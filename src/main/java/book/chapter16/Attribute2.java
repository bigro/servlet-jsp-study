package book.chapter16;

import book.bean.Product;
import book.dao.ProductDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = {"/attribute2"})
public class Attribute2 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        try {
            ProductDAO dao = new ProductDAO();
            List<Product> list = dao.search("");

            request.setAttribute("list", list);

            request.getRequestDispatcher("attribute2.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace(out);
        }
    }
}
