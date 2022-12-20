package dev.nevah5.m165_quiz.backend.controllers;

import com.google.gson.Gson;
import dev.nevah5.m165_quiz.backend.models.Question;
import dev.nevah5.m165_quiz.backend.repositories.QuestionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@CrossOrigin("*")
public class QuestionsController {
    QuestionsRepository questionsRepository;
    public QuestionsController(QuestionsRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }
    @GetMapping(value = "/quiz/{quizId}/question/{questionNumber}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getQuizQuestionByQuestionNumber(@PathVariable String quizId, @PathVariable Integer questionNumber){
        Question foundQuestion = questionsRepository.findQuestionByQuizIdIsAndQuestionNumber(quizId, questionNumber);
        if(foundQuestion == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), "This question was not found.");
        return new Gson().toJson(foundQuestion.getRequestResponse());
    }

    @GetMapping(value = "/question/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String getQuestionById(@PathVariable String id){
        Question foundQuestion = questionsRepository.findQuestionById(id);
        if(foundQuestion == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), "This question was not found.");
        return new Gson().toJson(foundQuestion.getRequestResponse());
    }

    @GetMapping(value = "/question/{id}/check/{guess}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public String checkQuestionAnswer(@PathVariable String id, @PathVariable Integer guess){
        Question foundQuestion = questionsRepository.findQuestionById(id);
        if(foundQuestion == null) throw new ResponseStatusException(HttpStatusCode.valueOf(404), "This question was not found.");
        return new Gson().toJson(foundQuestion.getCorrectResponse(guess));
    }
}