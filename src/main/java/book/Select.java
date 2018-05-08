package book;

import tool.Page;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = {"/select"})
public class Select extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        request.setCharacterEncoding("UTF-8");
        String count = request.getParameter("count");
        String payment = request.getParameter("payment");
        String review = request.getParameter("review");
        String mail = request.getParameter("mail");

        Page.header(out);
        out.println("<p>" + count + "この商品をカードに入れました</p>");
        out.println("<p>お支払い方法を" + payment + "に設定しました</p>");
        out.println("<p>ご感想ありがとうございます</p>");
        out.println("<p>[" + review + "]</p>");
        if(mail != null) {
            out.println("<p>メールをお送りします</p>");
        } else {
            out.println("<p>メールはお送りしません</p>");
        }
        Page.footer(out);
    }
}
