package br.com.lucascunha.app.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lucascunha.app.domain.model.Receita;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
	List<Receita> findAll();
	Optional<Receita> findById(Long id);
	Receita findReceitaByDescricaoAndData(String descricao, String data);
	Optional<Receita> findByDescricao(String descricao);
}
