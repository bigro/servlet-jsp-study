package book.chapter19;

import tool.Page;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

@WebServlet(urlPatterns = {"/chapter19/attribute"})
public class Attribute extends HttpServlet {
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Page.header(out);

        ServletContext context = getServletContext();
        String path = context.getRealPath("/WEB-INF/setting.txt");

        FileInputStream inputStream = new FileInputStream(path);
        Properties properties = new Properties();
        properties.load(inputStream);
        inputStream.close();

        for (String key : properties.stringPropertyNames()) {
            context.setAttribute(key, properties.getProperty(key));
        }
        out.println("アプリケーション属性を設定しました。");
        
        Page.footer(out);
    }
}
