package br.com.fiap.challengesprint.request;

import br.com.fiap.challengesprint.model.Categoria;
import br.com.fiap.challengesprint.validation.ExistingCategoria;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ProdutoRequest {

    @NotBlank
    private String nome;

    @NotBlank
    @ExistingCategoria(domainClass = Categoria.class, fieldName = "nome")
    private String categoria;

    @NotNull
    @PositiveOrZero
    private BigDecimal preco;

    @NotNull
    @PositiveOrZero
    @Max(999)
    private Integer quantidade;

    @Deprecated
    public ProdutoRequest() {}

    public ProdutoRequest(String nome, String categoria, BigDecimal preco, Integer quantidade) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

}
