package main.java.com.example.devOpsDemo.repository;

import main.java.com.example.devOpsDemo.entity.Question;
import main.java.com.example.devOpsDemo.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionByQuiz(Quiz quiz);

    void deleteAllByQuiz(Quiz quiz);
}
