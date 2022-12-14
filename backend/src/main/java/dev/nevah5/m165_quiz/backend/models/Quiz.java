package dev.nevah5.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quizzes")
public class Quiz {
    @Id
    @Generated
    @Getter
    private String id;
    @Getter
    @NonNull
    private String name;
    @Getter
    @NonNull
    private String createdBy;
    @Getter
    @NonNull
    private Integer createdOn;
    @Getter
    @NonNull
    private String[] tags;
}
