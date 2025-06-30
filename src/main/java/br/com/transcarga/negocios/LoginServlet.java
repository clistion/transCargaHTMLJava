package br.com.transcarga.negocios;

import br.com.transcarga.persistencia.User;
import br.com.transcarga.persistencia.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String u = req.getParameter("username");
    String p = req.getParameter("password");
    User user = new UserDAO().autenticar(u, p);
    if (user != null) {
      req.getSession().setAttribute("user", user);
      resp.sendRedirect("index.html");
    } else {
      resp.sendRedirect("login.html?error=1");
    }
  }
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    // Invalida a sessão do usuário
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }

    // Redireciona para a página de login
    response.sendRedirect("login.html");
  }
}