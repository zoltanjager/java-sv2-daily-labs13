package day03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizProcessTest {


    @Test
    void testReadAllLines(){

        QuizProcess quizProcess = new QuizProcess();
        quizProcess.readAllLines("src/main/resources/result.txt");

        System.out.println(quizProcess.getGoodAnswers());
        System.out.println(quizProcess.getResults());

        System.out.println(quizProcess.isRightAnswer("AB123", 2));
        System.out.println(quizProcess.isRightAnswer("GH1234", 3));

        System.out.println(quizProcess.getWinner());
    }

}