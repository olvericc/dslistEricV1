package com.devolveric.dslistV1.services;

import com.devolveric.dslistV1.dto.GameDTO;
import com.devolveric.dslistV1.dto.GameMinDTO;
import com.devolveric.dslistV1.entities.Game;
import com.devolveric.dslistV1.projections.GameMinProjection;
import com.devolveric.dslistV1.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public GameDTO findById(Long GameId) {
        Game result = gameRepository.findById(GameId).get();
        return new GameDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByGameList(Long listId){
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result.stream().map(GameMinDTO::new).toList();
    }

}
