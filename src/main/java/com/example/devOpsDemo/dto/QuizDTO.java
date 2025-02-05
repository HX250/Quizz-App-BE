package main.java.com.example.devOpsDemo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class QuizDTO {
    private Integer quizId;
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private UserDTO user;
    private List<QuestionDTO> questions;
    private List<CategoryDTO> categories;

    public Integer getQuizId() {
        return quizId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public UserDTO getUser() {
        return user;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public List<CategoryDTO> getCategories() {
        return categories;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public void setCategories(List<CategoryDTO> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "QuizDTO{" +
                "quizId=" + quizId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", questions=" + questions +
                ", categories=" + categories +
                '}';
    }
}