package net.geeler.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

public class Game {
    @MongoId
    @Getter
    @Generated
    private String id;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private String price;
    @Setter
    @Getter
    private Integer maxQuestionNumber;
    @Getter
    @Setter
    private Date started;
    @Getter
    @Setter
    private Date end;
}
