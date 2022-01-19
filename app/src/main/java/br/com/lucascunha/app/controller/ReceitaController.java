package br.com.lucascunha.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping("/{id}")
    public ResponseEntity<Receita> buscar(@PathVariable Long id) {
        return receitaRepository.findById(id)
                .map(receita -> ResponseEntity.ok(receita))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Receita salvar(@RequestBody Receita receita) {
        return receitaRepository.save(receita);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Receita> atualizar(@PathVariable Long id, 
            @Valid @RequestBody Receita receita) {
        if(!receitaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        receita.setId(id);
        receita.getDescricao();
        receita.getValor();
        receita.getData();

        return ResponseEntity.ok(receitaRepository.save(receita));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Receita> deletar(@PathVariable Long id) {
        if(!receitaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        receitaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
