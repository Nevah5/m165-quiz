package net.geeler.m165_quiz.backend.controllers;

import com.google.gson.Gson;
import net.geeler.m165_quiz.backend.models.Question;
import net.geeler.m165_quiz.backend.repositories.QuestionsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
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
}
