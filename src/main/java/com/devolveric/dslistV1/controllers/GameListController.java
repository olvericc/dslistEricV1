package com.devolveric.dslistV1.controllers;

import com.devolveric.dslistV1.dto.GameListDTO;
import com.devolveric.dslistV1.dto.GameMinDTO;
import com.devolveric.dslistV1.dto.ReplacementDTO;
import com.devolveric.dslistV1.services.GameListService;
import com.devolveric.dslistV1.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        return gameService.findByGameList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void movingList(@PathVariable Long listId, @RequestBody ReplacementDTO body) {
        gameListService.movingList(listId, body.getSourceIndex(), body.getDestinationIndex());
    }

}
