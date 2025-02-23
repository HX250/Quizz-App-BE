package main.java.com.example.devOpsDemo.service;

import jakarta.transaction.Transactional;
import main.java.com.example.devOpsDemo.dto.*;
import main.java.com.example.devOpsDemo.entity.*;
import main.java.com.example.devOpsDemo.exception.CustomException;
import main.java.com.example.devOpsDemo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuizCategoryRepository quizCategoryRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public QuizDTO getQuizById(Integer id) {
        Quiz quiz = quizRepository.findByQuizId(id)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found"));

        QuizDTO quizDTO = new QuizDTO();
        quizDTO.setQuizId(quiz.getQuizId());
        quizDTO.setTitle(quiz.getTitle());
        quizDTO.setDescription(quiz.getDescription());
        quizDTO.setCreatedAt(quiz.getCreatedAt());

        User user = userRepository.findUserByUserId(quiz.getUser().getUserId());
        System.out.println(user);
        UserDTO newUser = new UserDTO(user.getUserId(), user.getUsername(), user.getEmail());
        quizDTO.setUser(newUser);

        List<Question> questionList = questionRepository.findQuestionByQuiz(quiz);
        List<QuestionDTO> questionDTOList = QuestionDTO.fromEntityList(questionList);
        quizDTO.setQuestions(questionDTOList);

        List<QuizCategory> categoryList = quizCategoryRepository.findQuizCategoriesByQuiz(quiz);
        List<CategoryDTO> categoryDTOList = CategoryDTO.fromEntityList(categoryList);
        quizDTO.setCategories(categoryDTOList);

        return quizDTO;
    }

    public CreateQuizDTO createQuiz(CreateQuizDTO createQuizDTO) {
        if(createQuizDTO.getUserId() == null){
            throw new CustomException("Login is required, please");
        }

        User user = userRepository.findById(createQuizDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Quiz quiz = new Quiz();
        quiz.setTitle(createQuizDTO.getTitle());
        quiz.setDescription(createQuizDTO.getDescription());
        quiz.setCreatedAt(LocalDateTime.now());
        quiz.setUser(user);

        quiz = quizRepository.save(quiz);


        Quiz finalQuiz = quiz;
        List<Question> questions = createQuizDTO.getQuestions().stream().map(qDTO -> {
            Question question = new Question();
            question.setQuestionText(qDTO.getQuestionText());
            question.setCorrect(qDTO.getIsCorrect());
            question.setQuiz(finalQuiz);
            return question;
        }).collect(Collectors.toList());

        questionRepository.saveAll(questions);

        createQuizDTO.setQuestions(QuestionDTO.fromEntityList(questions));

        return createQuizDTO;
    }


    public void addCategoryToQuiz(Integer quizId, List<Integer> categoryIds) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with ID: " + quizId));

        List<QuizCategory> quizCategories = categoryIds.stream().map(categoryId -> {
            Category category = categoryRepository.findById(categoryId)
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + categoryId));

            QuizCategoryId quizCategoryId = new QuizCategoryId(quiz.getQuizId(), category.getCategoryId());

            QuizCategory quizCategory = new QuizCategory();
            quizCategory.setId(quizCategoryId);
            quizCategory.setQuiz(quiz);
            quizCategory.setCategory(category);

            return quizCategory;
        }).collect(Collectors.toList());

        quizCategoryRepository.saveAll(quizCategories);
    }


    @Transactional
    public void deleteQuiz(Integer quizId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with ID: " + quizId));

        quizRepository.delete(quiz);
    }

    @Transactional
    public void deleteCategory(Integer quizId, Integer categoryId) {
        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with ID: " + quizId));

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with ID: " + categoryId));

        QuizCategoryId quizCategoryId = new QuizCategoryId(quizId, categoryId);

        QuizCategory quizCategory = quizCategoryRepository.findById(quizCategoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not associated with the quiz"));

        quizCategoryRepository.delete(quizCategory);
    }

    public Quiz updateQuiz(Integer quizId, Quiz updatedQuiz) {
        Quiz existingQuiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new ResourceNotFoundException("Quiz not found with ID: " + quizId));

        if (updatedQuiz.getTitle() != null) {
            existingQuiz.setTitle(updatedQuiz.getTitle());
        }
        if (updatedQuiz.getDescription() != null) {
            existingQuiz.setDescription(updatedQuiz.getDescription());
        }

        return quizRepository.save(existingQuiz);
    }
}