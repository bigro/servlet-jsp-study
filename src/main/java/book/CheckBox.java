package book;

import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/checkbox"})
public class CheckBox extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        String[] genres = request.getParameterValues("genre");

        Page.header(out);
        if(genres != null) {
            for (String genre : genres) {
                out.println("[" + genre + "]");
            }
            out.println("に関するお買い得情報をお送りします");
        } else {
            out.println("お買い得情報はお送りしません");
        }
        Page.footer(out);
    }
}
