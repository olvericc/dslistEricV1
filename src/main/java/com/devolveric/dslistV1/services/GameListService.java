package com.devolveric.dslistV1.services;

import com.devolveric.dslistV1.dto.GameListDTO;
import com.devolveric.dslistV1.entities.Game;
import com.devolveric.dslistV1.entities.GameList;
import com.devolveric.dslistV1.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;
    @Autowired
    private GameService gameService;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }

}
