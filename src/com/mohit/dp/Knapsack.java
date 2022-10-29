package com.mohit.dp;

import java.util.Arrays;
import java.util.Random;

public class Knapsack {
    private static final int POPULATION = 30;
    private static final int TRACE = 100000;

    public static void main(String[] args) {
        /*
        KnapsackSolution bottomUp = new BottomUp();
        KnapsackSolution topDown = new TopDown();
        int[] values = {12, 10, 20, 15};
        int[] weights = {2, 1, 3, 2};
        int capacity = 5;
        System.out.println("BottomUp: " + bottomUp.getOptimalValue(values, weights, capacity));
        System.out.println("TopDown: " + topDown.getOptimalValue(values, weights, capacity));
        */

        deliverable2();
        deliverable3();
        // deliverable4();
    }

    public static void deliverable2() {
        System.out.println("Deliverable 2");
        Random random = new Random();
        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] bottomUpTimes = new long[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 101;
            int capacity = 100 + ((i + 4) * 3);

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[i] = random.nextInt(100 - 10) + 10;
                weights[i] = random.nextInt(capacity - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;

            KnapsackSolution bottomUp = new BottomUp();
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                bottomUp.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            bottomUpTimes[i] = elapsedTime / TRACE;

            KnapsackSolution topDown = new TopDown();
            elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;
        }

        System.out.println("n: " + Arrays.toString(ns));
        System.out.println("W: " + Arrays.toString(ws));
        System.out.println("BottomUp: " + Arrays.toString(bottomUpTimes));
        System.out.println("TopDown: " + Arrays.toString(topDownTimes));
    }

    public static void deliverable3() {
        System.out.println("Deliverable 3");
        Random random = new Random();

        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] bottomUpTimes = new long[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 110;
            int capacity = 100 + ((i + 4) * 3);

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[i] = random.nextInt(100 - 10) + 10;
                weights[i] = random.nextInt(10 - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;

            KnapsackSolution bottomUp = new BottomUp();
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                bottomUp.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            bottomUpTimes[i] = elapsedTime / TRACE;

            KnapsackSolution topDown = new TopDown();
            elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;
        }

        System.out.println("n: " + Arrays.toString(ns));
        System.out.println("W: " + Arrays.toString(ws));
        System.out.println("BottomUp: " + Arrays.toString(bottomUpTimes));
        System.out.println("TopDown: " + Arrays.toString(topDownTimes));
    }

    public static void deliverable4() {
        System.out.println("Deliverable 4");
        Random random = new Random();

        int[] wSizes = new int[POPULATION];
        long[] bottomUpTimes = new long[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 50 + ((i + 1) * 2);
            int capacity = (int) Math.pow(2, i + 1);

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[i] = random.nextInt(100 - 10) + 10;
                weights[i] = random.nextInt(capacity - 1) + 1;
            }

            wSizes[i] = (int) (Math.log10(capacity) + 1);
            long elapsedTime = 0;

            KnapsackSolution bottomUp = new BottomUp();
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                bottomUp.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            bottomUpTimes[i] = elapsedTime / TRACE;

            KnapsackSolution topDown = new TopDown();
            elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown.getOptimalValue(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;
        }

        System.out.println("W Size: " + Arrays.toString(wSizes));
        System.out.println("BottomUp: " + Arrays.toString(bottomUpTimes));
        System.out.println("TopDown: " + Arrays.toString(topDownTimes));
    }
}
