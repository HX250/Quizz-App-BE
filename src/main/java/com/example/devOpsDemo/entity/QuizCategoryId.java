package main.java.com.example.devOpsDemo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
class QuizCategoryId implements java.io.Serializable {
    private Integer quizId;
    private Integer categoryId;
}