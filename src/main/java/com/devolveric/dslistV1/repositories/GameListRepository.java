package com.devolveric.dslistV1.repositories;

import com.devolveric.dslistV1.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
