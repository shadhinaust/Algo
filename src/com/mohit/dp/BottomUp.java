package com.mohit.dp;

public class BottomUp implements KnapsackSolution {
    @Override
    public int getOptimalValue(int[] values, int[] weights, int capacity) {

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

        return matrix[row - 1][col - 1];
    }

    @Override
    public int getOptimalValueByIterative(int[] values, int[] weights, int capacity) {
        return 0;
    }
}
