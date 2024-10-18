package com.example.kbcgame.repository;

import com.example.kbcgame.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}