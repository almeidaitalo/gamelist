package com.devsuperior.dlist.controller;

import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.entities.Game;
import com.devsuperior.dlist.repository.GameRepository;
import com.devsuperior.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping
    public List<GameMinDTO> findAll(){
    List<GameMinDTO> result = gameService.findAll();
    return result;
    }
}
