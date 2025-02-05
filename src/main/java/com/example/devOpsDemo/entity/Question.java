package main.java.com.example.devOpsDemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "quiz_id", nullable = false)
    private Quiz quiz;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String questionText;

    @Column(name = "is_correct", nullable = false)
    private Boolean isCorrect;

    public Integer getQuestionId() {
        return questionId;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public String getQuestionText() {
        return questionText;
    }

    public Boolean getIsCorrect() {
        return isCorrect;
    }


    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setCorrect(Boolean correct) {
        isCorrect = correct;
    }
}
