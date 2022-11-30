package net.geeler.m165_quiz.backend.controllers;

import net.geeler.m165_quiz.backend.models.Question;
import net.geeler.m165_quiz.backend.repositories.QuestionsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionsController {
    QuestionsRepository questionsRepository;
    public QuestionsController(QuestionsRepository questionsRepository){
        this.questionsRepository = questionsRepository;
    }
    @GetMapping("/question/{id}")
    public String getQuestionById(@PathVariable String id){
        Question foundQuestion = questionsRepository.findQuestionById(id);
        if(foundQuestion == null) return "Not Found";
        String response = String.format("Quiz: %s<br />Question: %s<br /><br />%s<br />%s<br />%s<br />%s", foundQuestion.getQuizId(), foundQuestion.getQ(), foundQuestion.getA1(), foundQuestion.getA2(), foundQuestion.getA3(),foundQuestion.getA4());
        System.out.println(response);
        return response;
    }
}
