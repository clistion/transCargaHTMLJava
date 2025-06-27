package br.com.transcarga.negocios;

import br.com.transcarga.persistencia.UserDAO;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/usuario")
public class UsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    String role = request.getParameter("role");

    UserDAO dao = new UserDAO();
    dao.cadastrar(username, password, role);

    response.sendRedirect("login.html");
  }
}
