package main.java.com.example.devOpsDemo.repository;

import main.java.com.example.devOpsDemo.entity.Quiz;
import main.java.com.example.devOpsDemo.entity.QuizCategory;
import main.java.com.example.devOpsDemo.entity.QuizCategoryId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizCategoryRepository extends JpaRepository<QuizCategory, QuizCategoryId> {
    List<QuizCategory> findQuizCategoriesByQuiz(Quiz quiz);

    void deleteAllByQuiz(Quiz quiz);
}
