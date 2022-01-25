package br.com.lucascunha.app.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
@Entity
@Table(name = "receita")
public class Receita {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao")
    @NotBlank(message = "A descrição é obrigatória")
    @Size(max = 100, message = "A descrição deve ter no máximo {max} caracteres")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_vencimento")
    @NotBlank(message = "A data é obrigatória")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private String data;

    public Object map(Object object) {
        return null;
    }
}