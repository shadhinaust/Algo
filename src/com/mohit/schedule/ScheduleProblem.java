package com.mohit.schedule;

import java.util.Arrays;

public class ScheduleProblem {
    public static void main(String[] args) {
        Greedy greedy = new Greedy();
        int[] a = new int[]{1, 2, 4};
        int[] b = new int[]{3, 5, 5};
        System.out.println(Arrays.toString(greedy.earliestStart(a, b)));
        System.out.println(Arrays.toString(greedy.shortestDuration(a, b)));
        System.out.println(Arrays.toString(greedy.earliestFinish(a, b)));
    }
}