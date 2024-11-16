package com.devsuperior.dlist.repository;

import com.devsuperior.dlist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList,Long> {
    //operação responsavel por acessar, atualizar, e deletar dados
}
