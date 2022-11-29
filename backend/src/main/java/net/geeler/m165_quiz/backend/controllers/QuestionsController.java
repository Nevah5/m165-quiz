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
        Double r = Math.floor(Math.random() * 10);
        if(r >= 0 && r < 2.5) return foundQuestion.getQ1();
        if(r >= 2.5 && r < 5) return foundQuestion.getQ2();
        if(r >= 5 && r < 7.5) return foundQuestion.getQ3();
        return foundQuestion.getQ4();
    }
}
