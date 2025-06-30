
package br.com.transcarga.negocios;

import br.com.transcarga.persistencia.Frete;
import br.com.transcarga.persistencia.FreteDAO;
import br.com.transcarga.persistencia.User;
import br.com.transcarga.persistencia.UserDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
  
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

        List<User> usuarios = new UserDAO().listar();
        
	        request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        
	        out.println(" <h2>Lista de Usuários</h2>");	           	       
	        out.println("<table border='1'>");
	        out.println("<thead>"
		        		+ "<tr>"	        		
		        		+ "<th>login</th>"	        		
		        		+ "<th>Função</th>"
		        		+ "</tr>"
	        		+ "</thead>");
	        
	        for (User u : usuarios) {
	            out.printf("<tr><td>%s</td><td>%s</td></tr>",
	                     u.getUsername(), u.getRole());
	        }
	        out.println("</tbody></table>");       	   
	    }
}
