package net.geeler.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questions")
public class Question {
    @Id
    @Generated
    @Getter
    private String id;
    @Getter
    @NonNull
    private String quizId;
    @Getter
    @NonNull
    private String q;
    @Getter
    @NonNull
    private String a1;
    @Getter
    @NonNull
    private String a2;
    @Getter
    @NonNull
    private String a3;
    @Getter
    @NonNull
    private String a4;
    @Getter
    @NonNull
    private Integer c;
}
