package br.com.transcarga.negocios;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.*;
import java.io.IOException;
import br.com.transcarga.persistencia.User;

@WebFilter("/*")
public class AuthFilter implements Filter {
	
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest req = (HttpServletRequest) request;
    HttpServletResponse resp = (HttpServletResponse) response;
    String uri = req.getRequestURI();
        
    //Libera páginas públicas
    if (uri.endsWith("login") || uri.endsWith("login.html")) {
      chain.doFilter(request, response);
      return;
    }

    HttpSession session = req.getSession(false);
    User usuario = (session != null) ? (User) session.getAttribute("user") : null;
    
    if (usuario == null) {
        resp.sendRedirect("login.html");
        return;
      }

      // RESTRIÇÃO POR PAPEL
      String role = usuario.getRole(); // "USER" ou "ADMIN"

      if ("USER".equals(role)) {
        // Usuário comum só pode acessar a página de listar fretes
        if (uri.contains("listarFretes")) {
          chain.doFilter(request, response);
        } else {
          // Redireciona ou mostra erro de acesso
          resp.sendRedirect("listarFretes.html");
        }
      } else if ("ADMIN".equals(role)) {
        // Admin tem acesso a tudo
        chain.doFilter(request, response);
      } else {
        // Papel desconhecido
        resp.sendRedirect("login.html");
      }
  }  
}