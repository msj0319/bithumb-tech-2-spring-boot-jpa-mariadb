package net.msj0319.api.quiz.service;

import lombok.RequiredArgsConstructor;
import net.msj0319.api.quiz.domain.Quiz;
import org.springframework.stereotype.Service;

@Service @RequiredArgsConstructor
public class QuizServiceImpl implements QuizService{
    private final GeneratorService generatorService;
    @Override
    public Quiz createQuiz() {
        return new Quiz(
                generatorService.randomFactor(),
                generatorService.randomFactor()
        );
    }
}
