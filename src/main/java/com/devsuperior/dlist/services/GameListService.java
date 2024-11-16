package com.devsuperior.dlist.services;

import com.devsuperior.dlist.dto.GameDTO;
import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.entities.GameList;
import com.devsuperior.dlist.repository.GameListRepository;
import com.devsuperior.dlist.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
     List<GameList> result = gameListRepository.findAll();
     List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
     return dto;
    }

}
