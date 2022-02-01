package br.com.lucascunha.app.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucascunha.app.domain.model.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findAll();
    Optional<Despesa> findById(Long id);
    Despesa findDespesaByDescricaoAndData(String descricao, String data);
    List<Despesa> findByDescricao(String descricao);
}
