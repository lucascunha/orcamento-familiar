package br.com.lucascunha.app.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.lucascunha.app.domain.exception.NegocioException;
import br.com.lucascunha.app.domain.model.Receita;
import br.com.lucascunha.app.domain.repository.ReceitaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReceitaService {

    private ReceitaRepository receitaRepository;
    
    @Transactional
    public Receita salvar(Receita receita) {
        
        if(receitaRepository.findReceitaByDescricaoAndData(receita.getDescricao(), receita.getData()) != null) {
            throw new NegocioException("Já existe uma receita com esta descrição e data.");
        }

        return receitaRepository.save(receita);
    }
    
}
