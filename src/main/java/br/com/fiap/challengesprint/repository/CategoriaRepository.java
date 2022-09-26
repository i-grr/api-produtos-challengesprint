package br.com.fiap.challengesprint.repository;

import br.com.fiap.challengesprint.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    Categoria findByNome(String nome);

}
