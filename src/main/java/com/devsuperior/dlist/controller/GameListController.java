package com.devsuperior.dlist.controller;

import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.dto.ReplacementDTO;
import com.devsuperior.dlist.repository.GameRepository;
import com.devsuperior.dlist.services.GameListService;
import com.devsuperior.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> result = gameListService.findAll();
        return result;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> result = gameService.findByList(listId);
        return result;
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());

    }
}