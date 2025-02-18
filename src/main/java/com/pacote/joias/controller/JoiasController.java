package com.pacote.joias.controller;


import com.pacote.joias.model.Joias;
import com.pacote.joias.repository.JoiasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loja/joias")
public class JoiasController {

    @Autowired
    private JoiasRepository joiasRepository;

    @GetMapping
    public List<Joias> getAllJoias() {
        return joiasRepository.findAll();
    }

    @PostMapping
    public Joias createJoia(@RequestBody Joias joia) {
        return joiasRepository.save(joia);
    }

    @GetMapping("/{id}")
    public Joias getJoia(@PathVariable Long id) {
        return joiasRepository.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Joias updateJoia(@PathVariable Long id, @RequestBody Joias joia) {
        joia.setId(id);
        return joiasRepository.save(joia);
    }

    @DeleteMapping("/{id}")
    public void deleteJoia(@PathVariable Long id) {
        joiasRepository.deleteById(id);
    }
}
