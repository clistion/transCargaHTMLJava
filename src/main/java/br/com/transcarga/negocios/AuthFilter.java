package br.com.transcarga.negocios;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebFilter("/*")
public class AuthFilter implements Filter {
  public void doFilter(ServletRequest r, ServletResponse s, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) r;
    HttpServletResponse resp = (HttpServletResponse) s;
    String uri = req.getRequestURI();

    if (uri.endsWith("login") || uri.endsWith("login.html")) {
      chain.doFilter(r, s);
      return;
    }

    if (req.getSession().getAttribute("user") == null) {
      resp.sendRedirect("login.html");
    } else {
      chain.doFilter(r, s);
    }
  }
}