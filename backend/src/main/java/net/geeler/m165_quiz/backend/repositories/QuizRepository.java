package net.geeler.m165_quiz.backend.repositories;

import net.geeler.m165_quiz.backend.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    Quiz findQuizById(String id);
}
