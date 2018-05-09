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

@WebServlet(urlPatterns = {"/transaction"})
public class Transaction extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/book");
            Connection connection = dataSource.getConnection();

            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));
            
            connection.setAutoCommit(false);

            PreparedStatement statement = connection.prepareStatement("INSERT INTO test.product (name, price) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, price);
            statement.executeUpdate();

            statement = connection.prepareStatement("SELECT * FROM test.product WHERE name=?");
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();

            int line = 0;
            while (resultSet.next()) {
                line++;
            }
            
            if(line==1) {
                connection.commit();
                out.println("商品を登録しました");
            } else {
                connection.rollback();
                out.println("商品はすでに登録されています");
            }
            
            connection.setAutoCommit(true);
            
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Page.footer(out);
    }
}
