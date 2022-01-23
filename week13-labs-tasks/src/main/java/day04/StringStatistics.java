package day04;

import java.util.Map;
import java.util.TreeMap;

public class StringStatistics {

    private static final String VOWELS = "aeiou";

    public Map<Character, Integer> vowelCounter(String word) {
        Map<Character, Integer> result = new TreeMap<>();

        for (Character actual : word.toCharArray()) {
            if (isVowel(actual) && !result.containsKey(actual)) {
                result.put(actual, 1);
            } else if (isVowel(actual)) {
                result.put(actual, result.get(actual) + 1);
            }
        }
        return result;
    }

    private boolean isVowel(char c) {
        return VOWELS.indexOf(Character.toLowerCase(c)) >= 0;
    }
}
