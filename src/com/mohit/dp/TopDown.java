package com.mohit.dp;

public class TopDown implements KnapsackSolution {

    @Override
    public int getOptimalValue(int[] values, int[] weights, int capacity) {

        int row = values.length + 1;
        int col = capacity + 1;
        int[][] matrix = new int[row][col];
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                matrix[r][c] = -1;
            }
        }

        return mfKnapsack(values, weights, matrix, row - 1, capacity);
    }

    private int mfKnapsack(int[] values, int[] weights, int[][] matrix, int r, int c) {

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
}
