package com.devsuperior.dlist.controller;

import com.devsuperior.dlist.dto.GameDTO;
import com.devsuperior.dlist.dto.GameListDTO;
import com.devsuperior.dlist.dto.GameMinDTO;
import com.devsuperior.dlist.repository.GameRepository;
import com.devsuperior.dlist.services.GameListService;
import com.devsuperior.dlist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameRepository gameRepository;

    @GetMapping
    public List<GameListDTO> findAll(){
    List<GameListDTO> result = gameListService.findAll();
    return result;
    }
}