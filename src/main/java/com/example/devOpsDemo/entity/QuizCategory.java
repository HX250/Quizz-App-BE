package main.java.com.example.devOpsDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
@Table(name = "quiz_categories")
public class QuizCategory {
    @EmbeddedId
    private QuizCategoryId id;

    @ManyToOne
    @MapsId("quizId")
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;

    public Quiz getQuiz() { return quiz; }
    public void setQuiz(Quiz quiz) { this.quiz = quiz; }

    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }

    public void setId(QuizCategoryId id) {
        this.id = id;
    }
}