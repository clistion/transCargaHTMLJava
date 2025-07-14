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
        return "<!DOCTYPE html>" +
               "<html lang='pt-BR'>" +
               "<head>" +
               "  <meta charset='UTF-8'>" +
               "  <title>TransCarga - Sistema de Fretes</title>" +
               "</head>" +
               "<body>" +
               "  <h1>Bem-vindo ao sistema TransCarga</h1>" +
               "  <ul>" +
               "    <li><a href='cadastrarFrete.html'>Cadastrar Frete</a></li>" +
               "    <li><a href='listarFretes.html'>Listar Fretes</a></li>" +
               "    <li><a href='cadastrarUsuario.html'>Cadastrar Usuário</a></li>" +
               "    <li><a href='listarUsuarios.html'>Listar Usuários</a></li>" +
               "    <li><a href='/auth/logout'>Logout</a></li>" +
               "  </ul>" +
               "</body>" +
               "</html>";
    }
}
