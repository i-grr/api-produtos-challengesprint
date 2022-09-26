package br.com.fiap.challengesprint.controller;

import br.com.fiap.challengesprint.mapper.CategoriaMapper;
import br.com.fiap.challengesprint.repository.CategoriaRepository;
import br.com.fiap.challengesprint.response.CategoriaResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Api(value = "Endpoint de categorias")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaRepository repository;

    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaRepository repository, CategoriaMapper categoriaMapper) {
        this.repository = repository;
        this.categoriaMapper = categoriaMapper;
    }

    @ApiOperation(value = "Listagem de categorias cadastradas")
    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> listAll() {
        var categorias = repository.findAll();
        var categoriasResponse = categorias.stream().map(categoriaMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(categoriasResponse);
    }

}
