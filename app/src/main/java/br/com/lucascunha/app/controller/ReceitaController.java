package br.com.lucascunha.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.lucascunha.app.domain.model.Receita;
import br.com.lucascunha.app.domain.repository.ReceitaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/receitas")
public class ReceitaController {
    
    private ReceitaRepository receitaRepository;
    
    @GetMapping
    public List<Receita> listar(){
        return receitaRepository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita salvar(@RequestBody @Valid Receita receita) {
        return receitaRepository.save(receita);
    }
}
