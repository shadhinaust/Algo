package com.mohit.dp;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class KnappSackProblem {

    private static final int POPULATION = 20;
    private static final int TRACE = 10000;

    public static void main(String[] args) {
        smallInput();
        largeInput();
        wConstant();
        nConstant();
    }

    public static void smallInput() {
        System.out.println("Small Input");
        Random random = new Random();
        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] bottomUpTimes = new long[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 100 + (i * 2);
            int capacity = 100;

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[j] = random.nextInt(100 - 10) + 10;
                weights[j] = random.nextInt(capacity - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;

            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;

            elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                bottomUp(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            bottomUpTimes[i] = elapsedTime / TRACE;


        }

        String name = "small_input";
        String data = "n: " + Arrays.toString(ns) + "\nW: " + Arrays.toString(ws) + "\nBottomUp: " + Arrays.toString(bottomUpTimes) + "\nTopDown: " + Arrays.toString(topDownTimes);
        fileWriter(name, data);
    }

    public static void largeInput() {
        System.out.println("Large Input");
        Random random = new Random();
        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] bottomUpTimes = new long[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 1000 + (i * 4);
            int capacity = 1000;

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[j] = random.nextInt(100 - 10) + 10;
                weights[j] = random.nextInt(capacity - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;

            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;

            elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                bottomUp(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            bottomUpTimes[i] = elapsedTime / TRACE;
        }

        String name = "large_input";
        String data = "n: " + Arrays.toString(ns) + "\nW: " + Arrays.toString(ws) + "\nBottomUp: " + Arrays.toString(bottomUpTimes) + "\nTopDown: " + Arrays.toString(topDownTimes);
        fileWriter(name, data);
    }

    public static void wConstant() {
        System.out.println("w constant");
        Random random = new Random();
        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 200 + (i * 4);
            int capacity = 200;

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[j] = random.nextInt(100 - 10) + 10;
                weights[j] = random.nextInt(capacity - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;

            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;
        }

        String name = "w_constant";
        String data = "n: " + Arrays.toString(ns) + "\nW: " + Arrays.toString(ws) + "\nTopDown: " + Arrays.toString(topDownTimes);
        fileWriter(name, data);
    }

    public static void nConstant() {
        System.out.println("n constant");
        Random random = new Random();
        int[] ns = new int[POPULATION];
        int[] ws = new int[POPULATION];
        long[] topDownTimes = new long[POPULATION];

        for (int i = 0; i < POPULATION; i++) {
            int n = 200;
            int capacity = 150 + (i * 8);

            int[] values = new int[n];
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                values[j] = random.nextInt(100 - 10) + 10;
                weights[j] = random.nextInt(capacity - 1) + 1;
            }
            ns[i] = n;
            ws[i] = capacity;
            long elapsedTime = 0;
            for (int j = 0; j < TRACE; j++) {
                long startTime = System.nanoTime();
                topDown(values, weights, capacity);
                long endTime = System.nanoTime();
                elapsedTime += (endTime - startTime);
            }
            topDownTimes[i] = elapsedTime / TRACE;
        }

        String name = "n_constant";
        String data = "n: " + Arrays.toString(ns) + "\nW: " + Arrays.toString(ws) + "\nTopDown: " + Arrays.toString(topDownTimes);
        fileWriter(name, data);
    }

    public static void bottomUp(int[] values, int[] weights, int capacity) {

        int row = values.length + 1;
        int col = capacity + 1;
        int[][] matrix = new int[row][col];

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (c - weights[r - 1] < 0) {
                    matrix[r][c] = matrix[r - 1][c];
                } else {
                    matrix[r][c] = Math.max(matrix[r - 1][c], values[r - 1] + matrix[r - 1][c - weights[r - 1]]);
                }
            }
        }

    }

    private static int mfKnapsack(int[] values, int[] weights, int[][] matrix, int r, int c) {

        if (matrix[r][c] < 0) {
            int value;
            if (c < weights[r - 1]) {
                value = mfKnapsack(values, weights, matrix, r - 1, c);
            } else {
                value = Math.max(mfKnapsack(values, weights, matrix, r - 1, c), values[r - 1] + mfKnapsack(values, weights, matrix, r - 1, c - weights[r - 1]));
            }
            matrix[r][c] = value;
        }

        return matrix[r][c];
    }

    public static void topDown(int[] values, int[] weights, int capacity) {

        int row = values.length + 1;
        int col = capacity + 1;
        int[][] matrix = new int[row][col];
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                matrix[r][c] = -1;
            }
        }

        mfKnapsack(values, weights, matrix, row - 1, capacity);
    }

    public static void fileWriter(String name, String data) {
        try {
            String filename = name + ".txt";
            FileWriter myWriter = new FileWriter(filename);
            myWriter.write(data);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("Failed to write in file.");
            e.printStackTrace();
        }
    }
}
