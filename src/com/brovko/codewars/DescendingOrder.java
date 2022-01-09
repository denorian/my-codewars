package com.brovko.codewars;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DescendingOrder {
    /**
     * Your task is to make a function that can take any non-negative integer as an argument and
     * return it with its digits in descending order.
     * Essentially, rearrange the digits to create the highest possible number.
     */

    public static int sortDesc(final int num) {
        return Integer.parseInt(String.valueOf(num)
            .chars()
            .mapToObj(i -> String.valueOf(Character.getNumericValue(i)))
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.joining()));
    }


    @Test
    public void test_01() {
        assertEquals(0, DescendingOrder.sortDesc(0));
    }

    @Test
    public void test_02() {
        assertEquals(51, DescendingOrder.sortDesc(15));
    }


    @Test
    public void test_03() {
        assertEquals(987654321, DescendingOrder.sortDesc(123456789));
    }
}
