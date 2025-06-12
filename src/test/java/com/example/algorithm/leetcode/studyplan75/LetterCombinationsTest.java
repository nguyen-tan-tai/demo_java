package com.example.algorithm.leetcode.studyplan75;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * date: 2025-06-05
 * tags: java, algorithm, letterCombinations, backtracking
 */
class LetterCombinationsTest {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }
        result.add("");
        String[] digitToLetters = new String[] {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
        for (char digit : digits.toCharArray()) {
            System.out.print(result + "   ");
            String letters = digitToLetters[digit - '2'];
            List<String> temp = new ArrayList<>();
            for (String combination : result) {
                for (char letter : letters.toCharArray()) {
                    temp.add(combination + letter);
                }
            }
            System.out.println(result);
            result = temp;
        }
        return result;
    }

    @Test
    public void test() {
        System.out.println(letterCombinations("97"));
    }
}
