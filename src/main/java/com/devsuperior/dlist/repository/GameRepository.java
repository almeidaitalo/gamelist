package com.devsuperior.dlist.repository;

import com.devsuperior.dlist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game,Long> {
    //operação responsavel por acessar, atualizar, e deletar dados
}
