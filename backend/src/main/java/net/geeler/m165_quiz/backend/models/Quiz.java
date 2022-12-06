package net.geeler.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "quizzes")
public class Quiz {
    @Generated
    @MongoId
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
}
