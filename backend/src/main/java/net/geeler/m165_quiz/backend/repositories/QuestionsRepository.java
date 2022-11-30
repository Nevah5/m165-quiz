package net.geeler.m165_quiz.backend.repositories;

import net.geeler.m165_quiz.backend.models.Question;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepository extends MongoRepository<Question, String> {
    Question findQuestionById(String id);
    Question findQuestionsByQuizId(String quizId);
}
