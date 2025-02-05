package main.java.com.example.devOpsDemo.repository;

import main.java.com.example.devOpsDemo.entity.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    Optional<Quiz> findByQuizId(Integer quizId);
}
