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

import br.com.lucascunha.app.domain.model.Despesa;
import br.com.lucascunha.app.domain.repository.DespesaRepository;
import br.com.lucascunha.app.domain.service.DespesaService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/despesas")
public class DespesaController {

    private DespesaRepository despesaRepository;
    private DespesaService despesaService;

    @GetMapping
    public List<Despesa> listar() {
        return despesaRepository.findAll();
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Despesa> buscar(@PathVariable Long id) {
        return despesaRepository.findById(id)
                .map(despesa -> ResponseEntity.ok(despesa))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Despesa salvar(@RequestBody @Valid Despesa despesa) {
        //return despesaRepository.save(despesa);
        return despesaService.salvar(despesa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Despesa> atualizar(@PathVariable Long id, 
            @Valid @RequestBody Despesa despesa) {
        if(!despesaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        despesa.setId(id);
        despesa.getDescricao();
        despesa.getValor();
        return ResponseEntity.ok(despesaService.salvar(despesa));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Despesa> deletar(@PathVariable Long id) {
        if(!despesaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        despesaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
