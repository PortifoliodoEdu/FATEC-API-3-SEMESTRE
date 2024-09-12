package com.group.backend.domain.Tags;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "tags")
@Entity(name ="Tag")
@NoArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;
    private boolean ativo;

    public Tag(Long id, String nome, String descricao, Boolean ativo) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.ativo = ativo;
    }

    public Tag(DadosCadastroTag dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.descricao = dados.descricao();
    }

    public void atualizarTag(@Valid DadosAtualizacaoTag dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.descricao() != null) {
            this.descricao = dados.descricao();
        }
        if(dados.ativo() != null) {
            this.ativo = dados.ativo();
        }
    }
}

