package book.chapter23;

import book.bean.Product;
import book.dao.ProductDAO;
import tool.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class InsertAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        
        ProductDAO dao = new ProductDAO();
        dao.insert(product);

        List<Product> list = dao.search("");
        request.setAttribute("list", list);
        
        return "list.jsp";
    }
}
