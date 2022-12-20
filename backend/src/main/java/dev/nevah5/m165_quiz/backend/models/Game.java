package dev.nevah5.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document(collection = "games")
public class Game {
    @Id
    @Getter
    @Generated
    private String id;
    @Getter
    @Setter
    private String quizId;
    @Getter
    @Setter
    private String username;
    @Getter
    @Setter
    private Integer progress;
    @Setter
    @Getter
    private BigInteger startedOn;
    @Setter
    @Getter
    private BigInteger endedOn;
}
