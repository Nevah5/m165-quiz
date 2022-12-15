package dev.nevah5.m165_quiz.backend.controllers;

import com.google.gson.Gson;
import dev.nevah5.m165_quiz.backend.models.Quiz;
import dev.nevah5.m165_quiz.backend.repositories.QuizRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.List;

@RestController
public class QuizController {
    QuizRepository quizRepository;

    public QuizController(QuizRepository quizRepository){
        this.quizRepository = quizRepository;
    }

    @GetMapping(value = "/quizzes", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getQuizzes(){
        List<Quiz> foundQuizzes = quizRepository.findAll();
        return new Gson().toJson(foundQuizzes);
    }

    @GetMapping(value = "/quiz/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getQuizById(@PathVariable String id){
        Quiz foundQuiz = quizRepository.findQuizById(id);
        if(foundQuiz == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), "This quiz was not found.");
        return new Gson().toJson(foundQuiz);
    }

    @GetMapping(value = "/quiz/top", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getNewestQuiz(){
        List<Quiz> foundQuizzes = quizRepository.findAll();
        Collections.sort(foundQuizzes, (q1, q2) -> q2.getCreatedOn()- q1.getCreatedOn());
        return new Gson().toJson(foundQuizzes.get(0));
    }
}
