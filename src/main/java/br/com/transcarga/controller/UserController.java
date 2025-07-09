package br.com.transcarga.controller;

import br.com.transcarga.model.User;
import br.com.transcarga.repository.UserRepository;
import br.com.transcarga.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private AuthService auth;

    @GetMapping("/list")
    public List<User> list() {
        return userRepo.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody User user) {
        auth.register(user.getUsername(), user.getPassword(), user.getRole());
    }
}
