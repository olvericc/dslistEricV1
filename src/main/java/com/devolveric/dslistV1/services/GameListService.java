package com.devolveric.dslistV1.services;

import com.devolveric.dslistV1.dto.GameListDTO;
import com.devolveric.dslistV1.entities.GameList;
import com.devolveric.dslistV1.projections.GameMinProjection;
import com.devolveric.dslistV1.repositories.GameListRepository;
import com.devolveric.dslistV1.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll(){
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(GameListDTO::new).toList();
    }
    @Transactional
    public void movingList(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection object = list.remove(sourceIndex);
        list.add(destinationIndex, object);

        int minimal = Math.min(sourceIndex, destinationIndex);
        int maximal = Math.max(destinationIndex, sourceIndex);

        for (int i = minimal; i <= maximal; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
