package br.com.fiap.challengesprint.service;

import br.com.fiap.challengesprint.exception.ProdutoNotFoundException;
import br.com.fiap.challengesprint.model.Produto;
import br.com.fiap.challengesprint.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.el.MethodNotFoundException;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository repository;

    @Autowired
    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public List<Produto> getAll() {
        return repository.findAll();
    }

    public Produto getById(Long id) {
        var optProduto = repository.findById(id);
        return optProduto.orElseThrow(ProdutoNotFoundException::new);
    }

    public Produto save(Produto produto) {
        return repository.save(produto);
    }

    public Produto update(Long id, Produto produto) {
        var optProduto = repository.findById(id);

        if (optProduto.isEmpty())
            throw new ProdutoNotFoundException();

        var produtoAtualizado = optProduto.get();
        produtoAtualizado.update(produto);
        return repository.save(produtoAtualizado);
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id))
            throw new ProdutoNotFoundException();
        repository.deleteById(id);
    }
}
