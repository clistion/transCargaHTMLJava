package br.com.transcarga.negocios;
import br.com.transcarga.persistencia.Frete;
import br.com.transcarga.persistencia.FreteDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "FreteServlet", urlPatterns = {"/FreteServlet","/listarFretes.html"})
//@WebServlet("/FreteServlet")
public class FreteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
			  throws ServletException, IOException {
	        FreteDAO dao = new FreteDAO();
	        List<Frete> fretes = dao.listarFretes();
	        request.setCharacterEncoding("UTF-8");
	        response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println(" <h2>Lista de Fretes</h2>");	           	       
	        out.println("<table border='1'>");
	        out.println("<thead>"
	        		+ "<tr>"
	        		+ "<th>ID</th>"
	        		+ "<th>Destino</th>"
	        		+ "<th>Peso</th>"
	        		+ "<th>Transportadora</th></tr></thead>");
	        
	        for (Frete f : fretes) {
	            out.printf("<tr><td>%d</td><td>%s</td><td>%.2f</td><td>%s</td></tr>",
	                    f.getId(), f.getDestino(), f.getPeso(), f.getTransportadora());
	        }
	        out.println("</tbody></table>"); 
	        out.println("<br><a href='index.html'>Home</a>");  
	    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	request.setCharacterEncoding("UTF-8");
    	response.setContentType("text/html; charset=UTF-8");
	    
        String destino = request.getParameter("destino");
        double peso = Double.parseDouble(request.getParameter("peso"));
        String transportadora = request.getParameter("transportadora");

        Frete frete = new Frete();
        frete.setDestino(destino);
        frete.setPeso(peso);
        frete.setTransportadora(transportadora);

        FreteDAO dao = new FreteDAO();
        dao.cadastrarFrete(frete);     
        response.sendRedirect("listarFretes.html");
    }
        
}
