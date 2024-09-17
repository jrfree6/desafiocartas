package br.com.desafiocartas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafiocartas.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
