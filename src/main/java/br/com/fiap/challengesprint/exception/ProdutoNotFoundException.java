package br.com.fiap.challengesprint.exception;

public class ProdutoNotFoundException extends BusinessException {

    public ProdutoNotFoundException() {
        super("Produto não encontrado.");
    }

}