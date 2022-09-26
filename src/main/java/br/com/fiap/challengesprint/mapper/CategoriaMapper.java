package br.com.fiap.challengesprint.mapper;

import br.com.fiap.challengesprint.model.Categoria;
import br.com.fiap.challengesprint.response.CategoriaResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper {

    public CategoriaResponse toResponse(Categoria model) {
        return new CategoriaResponse(model.getNome());
    }

}
