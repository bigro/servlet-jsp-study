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

@WebServlet(urlPatterns = {"/chapter15/insert"})
public class Insert extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        try {
            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);

            ProductDAO productDAO = new ProductDAO();
            int line = productDAO.insert(product);

            if (line > 0) {
                out.println("追加に成功しました");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        Page.footer(out);
    }
}
