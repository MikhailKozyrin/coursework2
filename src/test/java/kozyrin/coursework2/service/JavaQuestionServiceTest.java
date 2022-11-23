package kozyrin.coursework2.service;

import kozyrin.coursework2.model.Question;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JavaQuestionServiceTest {
    QuestionService expectedService = new JavaQuestionService();

    @BeforeEach
    void addElements() {
        expectedService.add("Question1", "Answer1");
        expectedService.add("Question2", "Answer2");
        expectedService.add("Question3", "Answer3");
        expectedService.add("Question4", "Answer4");
    }

    @Test
    void add() {
        QuestionService actualService = new JavaQuestionService();
        actualService.add("Question1", "Answer1");
        actualService.add("Question2", "Answer2");
        actualService.add("Question3", "Answer3");
        actualService.add("Question4", "Answer4");

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void testAdd() {
        QuestionService actualService = new JavaQuestionService();
        Question question1 = new Question("Question1", "Answer1");
        Question question2 = new Question("Question2", "Answer2");
        Question question3 = new Question("Question3", "Answer3");
        Question question4 = new Question("Question4", "Answer4");

        actualService.add(question1);
        actualService.add(question2);
        actualService.add(question3);
        actualService.add(question4);

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void remove() {
        expectedService.remove(new Question("Question2", "Answer2"));
        expectedService.remove(new Question("Question4", "Answer4"));

        QuestionService actualService = new JavaQuestionService();
        actualService.add("Question1", "Answer1");
        actualService.add("Question3", "Answer3");

        assertThat(expectedService.getAll())
                .isEqualTo(actualService.getAll());
    }

    @Test
    void getRAnswerdomQuestion() {
        Question question = expectedService.getRandomQuestion();
        assertThat(expectedService.getAll().contains(question))
                .isTrue();
    }
}