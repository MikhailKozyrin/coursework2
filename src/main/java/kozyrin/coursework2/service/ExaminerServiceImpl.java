package kozyrin.coursework2.service;

import kozyrin.coursework2.exception.BigMoreRequestedException;
import kozyrin.coursework2.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private Random random;
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        if (amount > questionService.getAll().size() || amount < 1) {
            throw new BigMoreRequestedException("Запрошено слишком много вопросов");
        }
        Set<Question> resultQuestions = new HashSet<>();
        while (resultQuestions.size() < amount) {
            resultQuestions.add(questionService.getRandomQuestion());
        }

        return resultQuestions;
    }
}
