package br.com.fiap.challengesprint.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CategoriaResponse {

    @JsonProperty
    private String nome;

    public CategoriaResponse(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
