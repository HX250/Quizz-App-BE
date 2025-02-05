package main.java.com.example.devOpsDemo.dto;

import java.time.LocalDateTime;

public class QuizCompletionDTO {
    private Integer completionId;
    private Integer score;
    private LocalDateTime completedAt;
    private UserDTO user;
    private QuizDTO quiz;
}
