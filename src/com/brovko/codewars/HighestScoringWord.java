package com.brovko.codewars;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class HighestScoringWord {

    /** Given a string of words, you need to find the highest scoring word.
     * Each letter of a word scores points according to its position in the alphabet: a = 1, b = 2, c = 3 etc.
     * You need to return the highest scoring word as a string.
     * If two words score the same, return the word that appears earliest in the original string.
     * All letters will be lowercase and all inputs will be valid.
     */
    
    public static String high(String s) {
        return Arrays.stream(s.split(" "))
            .max(Comparator.comparingInt(
                    a -> a.chars().map(i -> i - 96).sum()
                ))
            .orElse("");
    }

    @Test
    public void sampleTests() {
        assertEquals("taxi", HighestScoringWord.high("man i need a taxi up to ubud"));
        assertEquals("volcano", HighestScoringWord.high("what time are we climbing up to the volcano"));
        assertEquals("semynak", HighestScoringWord.high("take me to semynak"));
    }

    @Test
    public void edgeCaseTests() {
        assertEquals("aa", HighestScoringWord.high("aa b"));
        assertEquals("b", HighestScoringWord.high("b aa"));
        assertEquals("bb", HighestScoringWord.high("bb d"));
        assertEquals("d", HighestScoringWord.high("d bb"));
        assertEquals("aaa", HighestScoringWord.high("aaa b"));
    }
}
