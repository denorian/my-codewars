package com.brovko.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiddleCharacter {
    public static String getMiddle(String word) {
        int length = word.length();

        if(length == 1) {
            return word;
        }else if(length % 2 == 0){
            return word.substring(length/2 - 1, length/2 + 1);
        } else {
            int ceil = (int) Math.ceil(length / 2f);
            return word.substring(ceil - 1, ceil);
        }
    }
    @Test
    public void evenTests() {
        assertEquals("es", MiddleCharacter.getMiddle("test"));
        assertEquals("dd", MiddleCharacter.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", MiddleCharacter.getMiddle("testing"));
        assertEquals("A", MiddleCharacter.getMiddle("A"));
    }
}
