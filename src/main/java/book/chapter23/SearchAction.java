package book.chapter23;

import book.bean.Product;
import book.dao.ProductDAO;
import tool.Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public class SearchAction extends Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String keyword = request.getParameter("keyword");
        ProductDAO dao = new ProductDAO();
        List<Product> list = dao.search(keyword);
        
        request.setAttribute("list", list);
        
        return "list.jsp";
    }
}
