package br.com.fiap.challengesprint.controller;

import br.com.fiap.challengesprint.response.ProdutoResponse;
import br.com.fiap.challengesprint.mapper.ProdutoMapper;
import br.com.fiap.challengesprint.request.ProdutoRequest;
import br.com.fiap.challengesprint.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    private final ProdutoMapper produtoMapper;

    public ProdutoController(ProdutoService produtoService, ProdutoMapper produtoMapper) {
        this.produtoService = produtoService;
        this.produtoMapper = produtoMapper;
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listAll() {
        var produtos = produtoService.getAll();
        var produtosResponse = produtos.stream().map(produtoMapper::toResponse).collect(Collectors.toList());
        return ResponseEntity.ok(produtosResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> findById(@PathVariable Long id) {
        var produto = produtoService.getById(id);
        var produtoResponse = produtoMapper.toResponse(produto);
        return ResponseEntity.ok(produtoResponse);
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> post(@RequestBody @Valid ProdutoRequest request) {
        var produto = produtoService.save(produtoMapper.toModel(request));
        var produtoResponse = produtoMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> put(@PathVariable Long id, @RequestBody @Valid ProdutoRequest request) {
        var produto = produtoService.update(id, produtoMapper.toModel(request));
        var produtoResponse = produtoMapper.toResponse(produto);
        return ResponseEntity.status(HttpStatus.OK).body(produtoResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        produtoService.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
