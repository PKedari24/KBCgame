package com.example.kbcgame.service;

import com.example.kbcgame.model.Player;
import com.example.kbcgame.model.Question;
import com.example.kbcgame.repository.PlayerRepository;
import com.example.kbcgame.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService { 
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions() { 
        return questionRepository.findAll();
    }

    public void savePlayer(Player player) { 
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() { 
        return playerRepository.findAll();
    }
}