package net.geeler.m165_quiz.backend.models;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;

public class Question {
    @Id
    @Getter
    @Setter
    private Integer id;
    @NonNull
    @Getter
    @Setter
    private Integer quizId;
    //questions
    @NonNull
    @Getter
    @Setter
    private String q1;
    @Getter
    @Setter
    @NonNull
    private String q2;
    @Getter
    @Setter
    @NonNull
    private String q3;
    @Getter
    @Setter
    @NonNull
    private String q4;
    @Getter
    @Setter
    @NonNull
    private Integer c; //correct answer
}
