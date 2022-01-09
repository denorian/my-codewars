package com.brovko.codewars;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertArrayEquals;

public class ArrayDiff {

    /**
     * Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.
     * It should remove all values from list a, which are present in list b keeping their order.
     * Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}
     * If a value is present in b, all of its occurrences must be removed from the other:
     * Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
     */

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b)
            .boxed()
            .collect(Collectors.toList());

        listA.removeAll(listB);

        return listA.stream().mapToInt(e -> e).toArray();

    }

    @Test
    public void sampleTests() {
        assertArrayEquals(new int[]{2}, ArrayDiff.arrayDiff(new int[]{1, 2}, new int[]{1}));
        assertArrayEquals(new int[]{2, 2}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{1}));
        assertArrayEquals(new int[]{1}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{2}));
        assertArrayEquals(new int[]{1, 2, 2}, ArrayDiff.arrayDiff(new int[]{1, 2, 2}, new int[]{}));
        assertArrayEquals(new int[]{}, ArrayDiff.arrayDiff(new int[]{}, new int[]{1, 2}));
    }
}
