package net.msj0319.api.quiz.service;

import net.msj0319.api.quiz.domain.Quiz;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class QuizServiceImplTest {
    private QuizServiceImpl quizService;    //알고리즘 담당
    @Mock
    GeneratorServiceImpl generatorService;  //리포지토리 담당

    @BeforeEach
    void setUp() {
        quizService = new QuizServiceImpl(generatorService);
    }
    @DisplayName("50 * 30 = 1500")
    @Test
    void createQuiz() {
        //랜덤값이 50,30이라면,
        given(generatorService.randomFactor()).willReturn(50,30);
        Quiz quiz = quizService.createQuiz();
        assertThat(quiz.getFactorA(), is(50));
        assertThat(quiz.getFactorB(), is(30));
        assertThat(quiz.getResult(), is(1500));
    }
}