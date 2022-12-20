package dev.nevah5.m165_quiz.backend.repositories;

import dev.nevah5.m165_quiz.backend.models.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    Quiz findQuizById(String id);
    List<Quiz> findQuizzesByTagsContaining(String tag);
}
