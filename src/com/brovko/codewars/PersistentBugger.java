package com.brovko.codewars;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistentBugger {
    /**
     * Write a function, persistence, that takes in a positive parameter num and returns its multiplicative persistence,
     * which is the number of times you must multiply the digits in num until you reach a single digit.
     * For example (Input --> Output):
     * 39 --> 3 (because 3*9 = 27, 2*7 = 14, 1*4 = 4 and 4 has only one digit)
     * 999 --> 4 (because 9*9*9 = 729, 7*2*9 = 126, 1*2*6 = 12, and finally 1*2 = 2)
     * 4 --> 0 (because 4 is already a one-digit number)
     */
    public static int persistence(long n) {
        long multi = 1, ans = 0;

        while (n >= 10) {
            while (n > 0) {
                multi = multi * (n % 10);
                n = n / 10;
            }
            if (multi >= 10)
                n = multi;
            multi = 1;
            ans++;
        }

        return (int) ans;
    }

    @Test
    public void BasicTests() {
        assertEquals(3, PersistentBugger.persistence(39));
        assertEquals(0, PersistentBugger.persistence(4));
        assertEquals(2, PersistentBugger.persistence(25));
        assertEquals(4, PersistentBugger.persistence(999));
    }
}
