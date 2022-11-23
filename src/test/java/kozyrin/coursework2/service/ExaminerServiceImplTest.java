package kozyrin.coursework2.service;

import kozyrin.coursework2.exception.BigMoreRequestedException;
import kozyrin.coursework2.model.Question;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {
    private final Set<Question> questions = new HashSet<>();

    @Mock
    private JavaQuestionService questionService;

    @InjectMocks
    private ExaminerServiceImpl examinerService;

    @BeforeEach
    public void addElements() {
        questions.add(new Question("Question1", "Answer1"));
        questions.add(new Question("Question2", "Answer2"));
        questions.add(new Question("Question3", "Answer3"));
        questions.add(new Question("Question4", "Answer4"));
        when(questionService.getAll()).thenReturn(questions);
    }
    @Test
    void getQuestionsPositive() {
        when(questionService.getRandomQuestion()).thenReturn(
                new Question("Question1", "Answer1"),
                new Question("Question1", "Answer1"),
                new Question("Question1", "Answer1"),
                new Question("Question3", "Answer3")
        );

        assertThat(examinerService.getQuestions(2))
                .hasSize(2)
                .containsExactlyInAnyOrder(
                        new  Question("Question1", "Answer1"),
                        new Question("Question3", "Answer3")
                );
    }

    @Test
    void getQuestionsNegative() {
        Assertions.assertThatExceptionOfType(BigMoreRequestedException.class)
                .isThrownBy(() -> examinerService.getQuestions(7))
                .withMessage("Запрошено слишком много вопросов");
    }
}