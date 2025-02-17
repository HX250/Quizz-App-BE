package main.java.com.example.devOpsDemo.controller;

import main.java.com.example.devOpsDemo.dto.AssignCategoriesDTO;
import main.java.com.example.devOpsDemo.dto.CreateQuizDTO;
import main.java.com.example.devOpsDemo.dto.QuizDTO;
import main.java.com.example.devOpsDemo.entity.Quiz;
import main.java.com.example.devOpsDemo.exception.CustomException;
import main.java.com.example.devOpsDemo.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;



@RestController
@RequestMapping("/quiz")
public class QuizController {
    private final QuizService quizService;

    @Autowired
    public QuizController( QuizService quizService) {
        this.quizService = quizService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDTO> getQuizById(@PathVariable Integer id) {
        return ResponseEntity.ok(quizService.getQuizById(id));
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody CreateQuizDTO createQuizDTO) {
        try {
            quizService.createQuiz(createQuizDTO);
            return ResponseEntity.ok("Quizz has been created");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (CustomException e){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PostMapping("/assign-categories")
    public ResponseEntity<String> addCategoryToQuiz(@RequestBody AssignCategoriesDTO assignCategoriesDTO) {
        try {
            quizService.addCategoryToQuiz(assignCategoriesDTO.getQuizId(), assignCategoriesDTO.getCategoryIds());
            return ResponseEntity.ok("Categories assigned successfully to the quiz.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @DeleteMapping("/{quizId}")
    public ResponseEntity<String> deleteQuiz(@PathVariable Integer quizId) {
        try {
            quizService.deleteQuiz(quizId);
            return ResponseEntity.ok("Quiz deleted successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @DeleteMapping("/{quizId}/categories/{categoryId}")
    public ResponseEntity<String> deleteCategoryForQuiz(@PathVariable Integer quizId, @PathVariable Integer categoryId) {
        try {
            quizService.deleteCategory(quizId ,categoryId);
            return ResponseEntity.ok("Quiz category deleted successfully.");
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    @PutMapping("/{quizId}")
    public ResponseEntity<Quiz> updateQuiz(
            @PathVariable Integer quizId,
            @RequestBody Quiz updatedQuiz) {

        Quiz quiz = quizService.updateQuiz(quizId, updatedQuiz);
        return ResponseEntity.ok(quiz);
    }

}
