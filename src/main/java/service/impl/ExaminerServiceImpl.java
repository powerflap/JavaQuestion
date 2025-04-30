package service.impl;



import model.Question;
import service.ExaminerService;
import service.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {
        List<Question> allQuestions = questionService.getAllQuestions();
        if (amount > allQuestions.size()) {
            throw new IllegalArgumentException("Requested more questions than available");
        }

        Random rand = new Random();
        List<Question> selectedQuestions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            int index = rand.nextInt(allQuestions.size());
            selectedQuestions.add(allQuestions.get(index));
            allQuestions.remove(index);
        }
        return selectedQuestions;
    }
}