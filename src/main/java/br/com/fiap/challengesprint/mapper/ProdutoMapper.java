package br.com.fiap.challengesprint.mapper;

import br.com.fiap.challengesprint.model.Categoria;
import br.com.fiap.challengesprint.repository.CategoriaRepository;
import br.com.fiap.challengesprint.response.ProdutoResponse;
import br.com.fiap.challengesprint.model.Produto;
import br.com.fiap.challengesprint.request.ProdutoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoMapper {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Produto toModel(ProdutoRequest request) {
        return new Produto(request.getNome(), categoriaRepository.findByNome(request.getCategoria()), request.getPreco(), request.getQuantidade());
    }

    public ProdutoResponse toResponse(Produto model) {
        return new ProdutoResponse(model.getId(), model.getNome(), model.getCategoria().getNome(), model.getPreco(), model.getQuantidade());
    }

}
