package br.com.fiap.challengesprint.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class ProdutoResponse {

    @JsonProperty
    private Long id;

    @JsonProperty
    private String nome;

    @JsonProperty
    private String categoria;

    @JsonProperty
    private BigDecimal preco;

    @JsonProperty
    private Integer quantidade;

    public ProdutoResponse(Long id, String nome, String categoria, BigDecimal preco, Integer quantidade) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

}
