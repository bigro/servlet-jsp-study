package book.chapter15;

import book.bean.Product;
import book.dao.ProductDAO;
import tool.Page;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

@WebServlet(urlPatterns = {"/chapter15/search"})
public class Search extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        
        try {
            String keyword = request.getParameter("keyword");
            ProductDAO productDAO = new ProductDAO();
            List<Product> products = productDAO.search(keyword);

            for (Product product : products) {
                out.println(product.getId());
                out.println(":");
                out.println(product.getName());
                out.println(":");
                out.println(product.getPrice());
                out.println("<br>");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Page.footer(out);
    }
}
