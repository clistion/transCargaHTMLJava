package br.com.transcarga.controller;

import br.com.transcarga.model.Frete;
import br.com.transcarga.repository.FreteRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    @Autowired
    private FreteRepository freteRepo;

    @GetMapping("/list")
    public List<Frete> list(HttpSession session) {
        return freteRepo.findAll();
    }

    @PostMapping("/add")
    public void add(@RequestBody Frete frete) {
        freteRepo.save(frete);
    }
}
