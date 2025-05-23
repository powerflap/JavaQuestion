package controller;

import model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.QuestionService;

import java.util.Collection;

@RestController
@RequestMapping("/exam/java")
public class JavaQuestionController {

    private final QuestionService service;

    @Autowired
    public JavaQuestionController(QuestionService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Question addQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.add(question, answer);
    }

    @GetMapping("")
    public Collection<Question> getQuestions() {
        return service.getAll();
    }

    @DeleteMapping("/remove")
    public Question removeQuestion(@RequestParam String question, @RequestParam String answer) {
        return service.remove(new Question(question, answer));
    }
}
