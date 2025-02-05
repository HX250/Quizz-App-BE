package main.java.com.example.devOpsDemo.dto;

import main.java.com.example.devOpsDemo.entity.QuizCategory;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryDTO {
    private Integer categoryId;
    private String name;
    private String description;

    public CategoryDTO(Integer categoryId, String name, String description) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
    }

    public static List<CategoryDTO> fromEntityList(List<QuizCategory> quizCategories) {
        return quizCategories.stream()
                .map(qc -> new CategoryDTO(qc.getCategory().getCategoryId(),
                        qc.getCategory().getName(),
                        qc.getCategory().getDescription()))
                .collect(Collectors.toList());
    }

    public Integer getCategoryId() { return categoryId; }
    public String getName() { return name; }
    public String getDescription() { return description; }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
