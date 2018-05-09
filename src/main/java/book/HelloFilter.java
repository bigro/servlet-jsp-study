package book;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();

        out.println("[HelloFilter(pre)]");
        chain.doFilter(request, response);
        out.println("[HelloFilter(post)]");
        
    }

    @Override
    public void destroy() {
    }
}
