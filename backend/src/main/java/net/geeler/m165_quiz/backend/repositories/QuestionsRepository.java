package net.geeler.m165_quiz.backend.repositories;

import net.geeler.m165_quiz.backend.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuestionsRepository extends MongoRepository<Question, String> {
    Question findQuestionById(String id);
    Question findQuestionsByQuizId(String id);
}
