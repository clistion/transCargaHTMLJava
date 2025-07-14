package br.com.transcarga.controller;

import br.com.transcarga.model.User;
import br.com.transcarga.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService auth;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        User user = auth.login(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @GetMapping("/logout")
    public ResponseEntity<Void> logout(HttpSession session, HttpServletResponse response) throws IOException {
        session.invalidate(); // Encerra a sessão
        response.sendRedirect("/login.html"); // Redireciona para a página de login
        return ResponseEntity.ok().build();
    }
}
