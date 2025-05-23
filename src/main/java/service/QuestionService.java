package service;





import model.Question;

import java.util.Collection;
import java.util.List;

public interface QuestionService {
    List<Question> getAllQuestions();
    void addQuestion(Question question);
    void removeQuestion(Question question);

    Collection<Question> getAll();

    Question add(String question, String answer);

    Question remove(Question question);
}