package com.devsuperior.dlist.services;

import com.devsuperior.dlist.dto.GameDTO;
import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.entities.GameList;
import com.devsuperior.dlist.projection.GameMinProjection;
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

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
     List<GameList> result = gameListRepository.findAll();
     List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList();
     return dto;
    }
    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex ){
        List<GameMinProjection> list = gameRepository.searchByList(listId);

        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min =  sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max =  sourceIndex < destinationIndex ? sourceIndex : destinationIndex;

        for(int i = min; i <= max; i++){
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i );
        }

    }
}
