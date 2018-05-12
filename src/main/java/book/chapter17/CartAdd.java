package book.chapter17;

import book.bean.Product;
import book.dao.ProductDAO;
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

@WebServlet(urlPatterns = {"/cart-add"})
public class CartAdd extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));

        HttpSession session = request.getSession();

        List<Product> cart = (List<Product>) session.getAttribute("cart");
        if (cart==null) {
            cart = new ArrayList<>();
        }

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        cart.add(product);
        
        session.setAttribute("cart", cart);
        
        out.println("カートに商品を追加しました。");

        Page.footer(out);
    }
}
