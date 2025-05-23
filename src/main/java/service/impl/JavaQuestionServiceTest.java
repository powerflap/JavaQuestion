package service.impl;

import model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;
import repository.QuestionRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class JavaQuestionServiceTest {

    private QuestionRepository repository;
    private JavaQuestionService service;

    @BeforeEach
    void setUp() {
        repository = mock(QuestionRepository.class);
        service = new JavaQuestionService(repository) {
            @Override
            public List<Question> getAllQuestions() {
                return List.of();
            }

            @Override
            public void addQuestion(Question question) {

            }

            @Override
            public void removeQuestion(Question question) {

            }
        };
    }

    @Test
    void addWithStringsShouldReturnQuestion() {
        Question q = new Question("Q", "A");
        when(repository.addQuestion(any())).thenReturn(q);

        Question result = service.add("Q", "A");
        assertEquals(q, result);
        verify(repository).addQuestion(q);
    }

    @Test
    void addWithQuestionObjectShouldReturnSameQuestion() {
        Question q = new Question("Q2", "A2");
        Question result = service.add(q);
        assertEquals(q, result);
        verify(repository).addQuestion(q);
    }

    @Test
    void removeQuestionShouldReturnQuestion() {
        Question q = new Question("Q3", "A3");
        OngoingStubbing<T> tOngoingStubbing = when(repository.removeQuestion(q)).thenReturn(q);
        Question result = service.remove(q);
        assertEquals(q, result);
        verify(repository).removeQuestion(q);
    }

    @Test
    void getAllShouldReturnAllQuestions() {
        List<Question> list = List.of(new Question("Q4", "A4"));
        when(repository.findAll()).thenReturn(list);

        Collection<Question> result = service.getAll();
        assertEquals(list, result);
    }

    @Test
    void getRandomQuestionReturnsOneOfList() {
        List<Question> list = List.of(
                new Question("Q1", "A1"),
                new Question("Q2", "A2")
        );
        when(repository.findAll()).thenReturn(list);

        Question result = service.getRandomQuestion();
        assertTrue(list.contains(result));
    }

    @Test
    void getRandomQuestionThrowsIfEmpty() {
        when(repository.findAll()).thenReturn(Collections.emptyList());
        assertThrows(NoSuchElementException.class, () -> service.getRandomQuestion());
    }
}
