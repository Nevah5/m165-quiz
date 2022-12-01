package net.geeler.m165_quiz.backend.models;

import lombok.Generated;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

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
    @Field("n")
    private Integer questionNumber;
    @Getter
    @NonNull
    @Field("q")
    private String question;
    @Getter
    @NonNull
    @Field("a1")
    private String answer1;
    @Getter
    @NonNull
    @Field("a2")
    private String answer2;
    @Getter
    @NonNull
    @Field("a3")
    private String answer3;
    @Getter
    @NonNull
    @Field("a4")
    private String answer4;
    @Getter
    @NonNull
    @Field("c")
    private Integer correct;

    /**
     * If a question is requested separately, it shouldn't return the correct answer. Logic is handled by the API.
     */
    public QuestionResponse getRequestResponse(){
        return new QuestionResponse(this);
    }

    /**
     * If checking response returns if is correct or wrong.
     */
    public CorrectResponse getCorrectResponse(Integer guessed){
        return new CorrectResponse(guessed, this);
    }
}
