package main.java.com.example.devOpsDemo.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuizCategoryId implements Serializable {
    private Integer quizId;
    private Integer categoryId;

    public QuizCategoryId() {}

    public QuizCategoryId(Integer quizId, Integer categoryId) {
        this.quizId = quizId;
        this.categoryId = categoryId;
    }

    public Integer getQuizId() { return quizId; }
    public Integer getCategoryId() { return categoryId; }

}
