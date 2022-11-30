package net.geeler.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "quiz")
public class Quiz {
    @Id
    @Generated
    @Getter
    @Setter
    private String id;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String createdBy;
}
