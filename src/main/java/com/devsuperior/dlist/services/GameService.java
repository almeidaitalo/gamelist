package com.devsuperior.dlist.services;

import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class GameService {

    //puxando uma instância interface GameRepository
    @Autowired
    private GameRepository gameRepository;

    //Responsavel por chamar o repository que busca na base de dados
    public List<GameMinDTO> findAll(){
    //função que retorna todos os games
     List<Game> result = gameRepository.findAll();
     List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
     return dto;
    }

}
