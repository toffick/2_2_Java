package Filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by DELL on 24.05.2017.
 */
@WebFilter(urlPatterns = {"/Login"})
public class FilterCod implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String encoding = req.getCharacterEncoding();
        if (!"UTF-8".equalsIgnoreCase(encoding))
            req.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
