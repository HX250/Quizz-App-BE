package main.java.com.example.devOpsDemo.dto;

import java.util.List;

public class AssignCategoriesDTO {
    private Integer quizId;
    private List<Integer> categoryIds;

    public Integer getQuizId() {
        return quizId;
    }

    public void setQuizId(Integer quizId) {
        this.quizId = quizId;
    }

    public List<Integer> getCategoryIds() {
        return categoryIds;
    }

    public void setCategoryIds(List<Integer> categoryIds) {
        this.categoryIds = categoryIds;
    }
}
