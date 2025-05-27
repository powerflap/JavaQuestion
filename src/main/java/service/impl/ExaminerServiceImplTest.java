package service.impl;

import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import service.QuestionService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ExaminerServiceImplTest {

    private QuestionService questionService;
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    void setUp() {
        questionService = mock(QuestionService.class);
        examinerService = new ExaminerServiceImpl(questionService);
    }

    @Test
    void getQuestionsReturnsCorrectAmount() {
        List<Question> questionPool = Arrays.asList(
                new Question("Q1", "A1"),
                new Question("Q2", "A2"),
                new Question("Q3", "A3"),
                new Question("Q4", "A4"),
                new Question("Q5", "A5")
        );

        when(questionService.getAllQuestions()).thenReturn(new ArrayList<>(questionPool));

        List<Question> result = examinerService.getQuestions(3);

        assertEquals(3, result.size());
        assertEquals(3, result.stream().distinct().count());
    }

    @Test
    void getQuestionsThrowsIfAmountGreaterThanAvailable() {
        List<Question> smallPool = List.of(new Question("Q1", "A1"));
        when(questionService.getAllQuestions()).thenReturn(new ArrayList<>(smallPool));

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            examinerService.getQuestions(2);
        });

        assertEquals("Requested more questions than available", exception.getMessage());
    }

    @Test
    void getQuestionsWithExactAmountReturnsAllQuestionsWithoutDuplication() {
        List<Question> questions = Arrays.asList(
                new Question("Q1", "A1"),
                new Question("Q2", "A2")
        );
        when(questionService.getAllQuestions()).thenReturn(new ArrayList<>(questions));

        List<Question> result = examinerService.getQuestions(2);

        assertEquals(2, result.size());
        assertTrue(result.containsAll(questions));
    }
}
