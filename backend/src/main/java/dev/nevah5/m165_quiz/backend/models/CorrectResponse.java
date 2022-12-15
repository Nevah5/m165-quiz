package dev.nevah5.m165_quiz.backend.models;

public class CorrectResponse {
    private Boolean answer = false;

    public CorrectResponse(Integer guessed, Question q){
        if(guessed == q.getCorrect()) this.answer = true;
    }
}
