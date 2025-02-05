package main.java.com.example.devOpsDemo.dto;

import java.time.LocalDateTime;
import java.util.List;

public class CreateQuizDTO {
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Integer userId;
    private List<QuestionDTO> questions;
    private List<Integer> categoryId;



    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setQuestions(List<QuestionDTO> questions) {
        this.questions = questions;
    }

    public void setCategoryId(List<Integer> categoryId) {
        this.categoryId = categoryId;
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

    public Integer getUserId() {
        return userId;
    }

    public List<QuestionDTO> getQuestions() {
        return questions;
    }

    public List<Integer> getCategoryId() {
        return categoryId;
    }
}
