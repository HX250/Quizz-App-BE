package main.java.com.example.devOpsDemo.dto;

import main.java.com.example.devOpsDemo.entity.Question;
import java.util.List;
import java.util.stream.Collectors;

public class QuestionDTO {
    private Integer questionId;
    private String questionText;
    private Boolean isCorrect;

    public QuestionDTO(Integer questionId, String questionText, Boolean isCorrect) {
        this.questionId = questionId;
        this.questionText = questionText;
        this.isCorrect = isCorrect;
    }

    public static List<QuestionDTO> fromEntityList(List<Question> questions) {
        return questions.stream()
                .map(q -> new QuestionDTO(q.getQuestionId(), q.getQuestionText(), q.getIsCorrect()))
                .collect(Collectors.toList());
    }

    // Getters
    public Integer getQuestionId() { return questionId; }
    public String getQuestionText() { return questionText; }
    public Boolean getIsCorrect() { return isCorrect; }

    @Override
    public String toString() {
        return "QuestionDTO{" +
                "questionId=" + questionId +
                ", questionText='" + questionText + '\'' +
                ", isCorrect=" + isCorrect +
                '}';
    }
}
