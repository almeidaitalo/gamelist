package com.devsuperior.dlist.services;

import com.devsuperior.dlist.dto.GameDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
public class GameService {

    //puxando uma instância interface GameRepository
    @Autowired
    private GameRepository gameRepository;

    //metodo para buscar pelo id
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }
    //Responsavel por chamar o repository que busca na base de dados
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
    //função que retorna todos os games
     List<Game> result = gameRepository.findAll();
     List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
     return dto;
    }

}
