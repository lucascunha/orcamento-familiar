package br.com.lucascunha.app.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
    @Size(max = 255, message = "A descrição deve ter entre {min} e {max} caracteres")
    private String descricao;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data_vencimento")
    @NotBlank(message = "A data é obrigatória")
    private String data;

    public Object map(Object object) {
        return null;
    }
}