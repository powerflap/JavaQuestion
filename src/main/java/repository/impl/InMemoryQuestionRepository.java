package repository.impl;






import model.Question;
import repository.QuestionRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryQuestionRepository implements QuestionRepository {
    private final List<Question> questions = new ArrayList<>();

    @Override
    public List<Question> findAll() {
        return questions;
    }

    @Override
    public void addQuestion(Question question) {
        questions.add(question);
    }

    @Override
    public void removeQuestion(Question question) {
        questions.remove(question);
    }
}