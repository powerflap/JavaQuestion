package repository;


import model.Question;
import java.util.List;

public interface QuestionRepository {
    List<Question> findAll();
    void addQuestion(Question question);
    void removeQuestion(Question question);
}