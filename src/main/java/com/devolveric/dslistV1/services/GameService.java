package com.devolveric.dslistV1.services;

import com.devolveric.dslistV1.dto.GameMinDTO;
import com.devolveric.dslistV1.entities.Game;
import com.devolveric.dslistV1.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

}
