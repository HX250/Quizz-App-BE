package main.java.com.example.devOpsDemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @Column(name = "quiz_id", nullable = false)
    private Integer quizId;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;

    public Integer getQuestionId() {
        return questionId;
    }


    public String getQuestionText() {
        return questionText;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
