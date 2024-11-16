package com.devsuperior.dlist.controller;

import com.devsuperior.dlist.dto.GameDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.repository.GameRepository;
import com.devsuperior.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "games")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping(value = "/{id}")
    public GameDTO findAllById(@PathVariable Long id) {
       GameDTO result = gameService.findById(id);
       return result;
    }
    @GetMapping
    public List<GameMinDTO> findAll(){
    List<GameMinDTO> result = gameService.findAll();
    return result;
    }
}
