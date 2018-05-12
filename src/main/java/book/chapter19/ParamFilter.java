package book.chapter19;


import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamFilter implements Filter {
    
    private String message;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        message = filterConfig.getInitParameter("message");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        out.println(message);
        chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
    }
}
