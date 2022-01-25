package br.com.lucascunha.app.domain.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.lucascunha.app.domain.exception.NegocioException;
import br.com.lucascunha.app.domain.model.Despesa;
import br.com.lucascunha.app.domain.repository.DespesaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class DespesaService {
    
    private DespesaRepository despesaRepository;

    @Transactional
    public Despesa salvar(Despesa despesa) {
        
        if(despesaRepository.findDespesaByDescricaoAndData(despesa.getDescricao(), despesa.getData()) != null) {
            throw new NegocioException("Já existe uma despesa com esta descrição e data.");
        }
        
        return despesaRepository.save(despesa);
    }   

}
