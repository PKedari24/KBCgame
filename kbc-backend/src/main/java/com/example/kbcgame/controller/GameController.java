package com.example.kbcgame.controller;

import com.example.kbcgame.model.Player;
import com.example.kbcgame.model.Question;
import com.example.kbcgame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class GameController { 
    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String index(Model model) {
        List<Question> questions = gameService.getAllQuestions(); 
        model.addAttribute("questions", questions);
        return "index";
    }

    @GetMapping("/game")
    public String game(Model model) {
        List<Question> questions = gameService.getAllQuestions(); 
        model.addAttribute("questions", questions);
        return "game";
    }

    @PostMapping("/answer")
    @ResponseBody
    public String answer(@RequestParam String playerName, @RequestParam String answer) { 
        List<Question> questions = gameService.getAllQuestions();
        Question currentQuestion = questions.get(0); // Just for demo, consider the first question 
        Player player = new Player();
        player.setName(playerName);

        if (currentQuestion.getCorrectAnswer().equalsIgnoreCase(answer)) { 
            player.setCorrect(true);
            gameService.savePlayer(player);
            return "Congratulations " + playerName + "!";
        } else {
            player.setCorrect(false); 
            gameService.savePlayer(player); 
            return "Wrong answer, " + playerName;
        }
    }
}