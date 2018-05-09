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

@WebServlet(urlPatterns = {"/insert"})
public class Insert extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        try {
            InitialContext initialContext = new InitialContext();
            DataSource dataSource = (DataSource) initialContext.lookup("java:/comp/env/jdbc/book");
            Connection connection = dataSource.getConnection();

            String name = request.getParameter("name");
            int price = Integer.parseInt(request.getParameter("price"));

            PreparedStatement statement = connection.prepareStatement("INSERT INTO test.product (name, price) VALUES (?,?)");
            statement.setString(1, name);
            statement.setInt(2, price);
            int line = statement.executeUpdate();

            if (line > 0) {
                out.println("追加に成功しました");
            }

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        Page.footer(out);
    }
}
