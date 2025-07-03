package br.com.transcarga.negocios;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HomeServlet", urlPatterns = {"/index.html"})
//@WebServlet("HomeServlet")
public class HomeServlet extends HttpServlet {
 
	private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    
    out.println("  <h1>Bem-vindo ao sistema TransCarga</h1>");
    out.println("  <ul>");
    out.println("    <li><a href='cadastrarFrete.html'>Cadastrar Frete</a></li>");
    out.println("    <li><a href='listarFretes.html'>Listar Fretes</a></li>");
    out.println("    <li><a href='cadastrarUsuario.html'>Cadastrar Usuário</a></li>");
    out.println("    <li><a href='listarUsuarios.html'>Listar Usuários</a></li>");
    out.println("    <li><a href='login.html'>Logout</a></li>");
    out.println("  </ul>");
  }
}
