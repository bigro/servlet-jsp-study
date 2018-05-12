package book.chapter18;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/chapter18/add"})
public class Add extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = "name";
        String value = "value";
        Cookie cookie = new Cookie(name, value);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }
}
