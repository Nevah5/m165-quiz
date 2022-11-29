package net.geeler.m165_quiz.backend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionsController {
    @GetMapping("question/{id}")
    public String test(@PathVariable String id){
        return id;
    }
}
