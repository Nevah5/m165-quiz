package dev.nevah5.m165_quiz.backend.repositories;

import dev.nevah5.m165_quiz.backend.models.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GamesRepository extends MongoRepository<Game, String> {
    List<Game> getGamesByQuizId(String id);
}
