package net.geeler.m165_quiz.backend.controllers;

import com.google.gson.Gson;
import net.geeler.m165_quiz.backend.models.Quiz;
import net.geeler.m165_quiz.backend.repositories.QuizRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuizController {
    QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    @GetMapping(value = "/quizzes", produces = "application/json")
    public String getQuizzes(){
        List<Quiz> foundQuizzes = quizRepository.findAll();
        return new Gson().toJson(foundQuizzes);
    }
}
