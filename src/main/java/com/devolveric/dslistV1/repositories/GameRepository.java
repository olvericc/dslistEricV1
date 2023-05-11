package com.devolveric.dslistV1.repositories;

import com.devolveric.dslistV1.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
