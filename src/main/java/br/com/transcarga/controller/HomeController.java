package br.com.transcarga.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {
	@GetMapping
    @ResponseBody
    public String home() {
        return 
        
        "<!DOCTYPE html>\r\n"
        + "<html lang=\"pt-BR\">\r\n"
        + "<head>\r\n"
        + "    <meta charset=\"UTF-8\">\r\n"
        + "    <title>TransCarga - Início</title>\r\n"
        + "    <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\">\r\n"
        + "    <link rel=\"stylesheet\" href=\"/css/home.css\">\r\n"
        + "</head>\r\n"
        + "<body class=\"bg-light d-flex flex-column min-vh-100\">\r\n"
        + "\r\n"
        + "    <nav class=\"navbar navbar-expand-lg navbar-dark bg-primary\">\r\n"
        + "        <div class=\"container\">\r\n"
        + "            <a class=\"navbar-brand\" href=\"#\">TransCarga</a>\r\n"
        + "            <div class=\"collapse navbar-collapse\">\r\n"
        + "                <ul class=\"navbar-nav ms-auto\">\r\n"
        + "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"cadastrarFrete.html\">Cadastrar Fretes</a></li>\r\n"
        + "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"listarFretes.html\">Listar Fretes</a></li>\r\n"
        + "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\" cadastrarUsuario.html\">Cadastrar Usuários</a></li>\r\n"
        + "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"listarUsuarios.html\">Listar Usuários</a></li>\r\n"            
        + "                    <li class=\"nav-item\"><a class=\"nav-link\" href=\"/auth/logout\">Sair</a></li>\r\n"
        + "                </ul>\r\n"
        + "            </div>\r\n"
        + "        </div>\r\n"
        + "    </nav>\r\n"
        + "\r\n"
        + "    <main class=\"flex-grow-1 d-flex justify-content-center align-items-center text-center\">\r\n"
        + "        <div class=\"home-container text-center\">\r\n"
        + "            <h1 class=\"display-4\">Bem-vindo ao Sistema TransCarga</h1>\r\n"
        + "            <p class=\"lead mb-4\">Gerencie fretes com eficiência.</p>\r\n"
        + "\r\n"
        + "            <div class=\"d-flex justify-content-center gap-3 flex-wrap btn-group-home\">\r\n"
        + "<img src=\"/img/logo-transcarga.gif\" alt=\"Logo TransCarga\" class=\"logo\">\r\n"
        + "                <a href=\"cadastrarFrete.html\" class=\"btn btn-outline-primary btn-lg\">Cadastrar Fretes</a>\r\n"
        + "                <a href=\"listarFretes.html\" class=\"btn btn-outline-secondary btn-lg\">Listar Fretes</a>\r\n"
        + "				   <a href=\"cadastrarUsuario.html\" class=\"btn btn-outline-primary btn-lg\">Cadastrar Usuários</a>\r\n"
        + "               <a href=\"listarusuarios.html\" class=\"btn btn-outline-secondary btn-lg\">Listar Usuários</a>\r\n"
        + "            </div>\r\n"
        + "        </div>\r\n"
        + "    </main>\r\n"
        + "<!-- Logo animada -->\r\n"
        
        + "\r\n"
        + "    <footer class=\"text-center text-muted py-3\">\r\n"
        + "        &copy; 2025 TransCarga. Todos os direitos reservados.\r\n"
        + "    </footer>\r\n"
        + "\r\n"
        + "    <script\r\n"
        + "		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\"\r\n"
        + "		integrity=\"sha384-ENjdO4Dr2bkBIFxQpeoA6VKHrj6kUaaK8hZtEzI59lZ2sDZE+Fj7bPbZefUewf0Q\"\r\n"
        + "		crossorigin=\"anonymous\">\r\n"
        + "</script>"
    
        + "</body>\r\n"
        + "</html>\r\n";
    }
}
