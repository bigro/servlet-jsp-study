package book.chapter14;

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

@WebServlet(urlPatterns = {"/search"})
public class Search extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);
        
        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource)initialContext.lookup("java:/comp/env/jdbc/book");
            Connection connection = dataSource.getConnection();

            String keyword = request.getParameter("keyword");

            PreparedStatement statement = connection.prepareStatement("SELECT * FROM test.product WHERE name LIKE ?");
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                out.println(resultSet.getInt("id"));
                out.println(":");
                out.println(resultSet.getString("name"));
                out.println(":");
                out.println(resultSet.getInt("price"));
                out.println("<br>");
            }
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        Page.footer(out);
    }
}
