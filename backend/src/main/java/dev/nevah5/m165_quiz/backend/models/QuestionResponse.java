package dev.nevah5.m165_quiz.backend.models;

import lombok.Setter;

public class QuestionResponse {
    @Setter
    private String id;
    @Setter
    private String question;
    @Setter
    private String answer1;
    @Setter
    private String answer2;
    @Setter
    private String answer3;
    @Setter
    private String answer4;

    public QuestionResponse(Question question){
        this.id = question.getId();
        this.question = question.getQuestion();
        this.answer1 = question.getAnswer1();
        this.answer2 = question.getAnswer2();
        this.answer3 = question.getAnswer3();
        this.answer4 = question.getAnswer4();
    }
}
