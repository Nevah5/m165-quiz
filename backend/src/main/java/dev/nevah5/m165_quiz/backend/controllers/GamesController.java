package dev.nevah5.m165_quiz.backend.controllers;

import com.google.gson.Gson;
import dev.nevah5.m165_quiz.backend.models.Game;
import dev.nevah5.m165_quiz.backend.repositories.GamesRepository;
import dev.nevah5.m165_quiz.backend.repositories.QuestionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class GamesController {
    GamesRepository gamesRepository;

    public GamesController(GamesRepository gamesRepository){
        this.gamesRepository = gamesRepository;
    }
    @PostMapping(value = "/games", produces = "application/json", consumes = "text/plain")
    @ResponseStatus(HttpStatus.OK)
    public String getQuestionById(@RequestBody String gameData){
        Game g = new Gson().fromJson(gameData, Game.class);
        gamesRepository.save(g);
        return new Gson().toJson(g);
    }
}
