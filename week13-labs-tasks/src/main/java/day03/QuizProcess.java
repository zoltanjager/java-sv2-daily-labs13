package day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class QuizProcess {

    private Map<String, String> results = new HashMap<>();
    private String goodAnswers;


    public void readAllLines(String fileName) {

        try (BufferedReader br = Files.newBufferedReader(Path.of(fileName))) {
            String line;
            goodAnswers = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] part = line.split(" ");
                String applicant = part[0];
                String answer = part[1];
//                if (results.keySet().contains(applicant)) {
                if (results.containsKey(applicant)) {
                    results.put(applicant, results.get(applicant) + answer);
                } else {
                    results.put(applicant, answer);
                }
            }
        } catch (IOException e) {
            throw new IllegalStateException("Cannot open the file", e);
        }
    }

    public boolean isRightAnswer(String applicant, int questionNumber) {
        return results.get(applicant).charAt(questionNumber - 1) == goodAnswers.charAt(questionNumber - 1);
    }

    public String getWinner() {
        Map<String, Integer> pointsMap = new HashMap<>();

        for (Map.Entry<String, String> actual : results.entrySet()) {
            int points = 0;
            for (int i = 0; i < goodAnswers.length(); i++) {
                if (isRightAnswer(actual.getKey(), i + 1)) {
                    points += i + 1;
                } else if (actual.getValue().charAt(i) != 'X') {
                    points -= 2;
                }

            }
            pointsMap.put(actual.getKey(), points);
        }

        String winner = null;
        int maxPoint = 0;
        for (Map.Entry<String, Integer> actual : pointsMap.entrySet()) {

            if (actual.getValue() > maxPoint) {
                maxPoint = actual.getValue();
                winner = actual.getKey();
            }
        }
        return winner;
    }


    public Map<String, String> getResults() {
        return results;
    }

    public String getGoodAnswers() {
        return goodAnswers;
    }
}
