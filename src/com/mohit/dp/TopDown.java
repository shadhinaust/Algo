package com.mohit.dp;

import java.util.ArrayList;
import java.util.List;

public class TopDown implements KnapsackSolution {

    // TODO: complete iterative process.
    @Override
    public int getOptimalValueByIterative(int[] values, int[] weights, int capacity) {

        int row = values.length + 1;
        int col = capacity + 1;
        int[][] matrix = new int[row][col];
        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                matrix[r][c] = -1;
            }
        }
        List<Integer> itemsStack = new ArrayList<>();
        List<Integer> weightStack = new ArrayList<>();

        int idx = 0;
        itemsStack.add(row - 1);
        weightStack.add(capacity);
        int item = 0, weight = 0;
        do {
            item = itemsStack.get(idx);
            weight = weightStack.get(idx);
            if (matrix[item][weight] < 0) {
                if (weight < weights[item - 1]) {
                    itemsStack.add(item - 1);
                    weightStack.add(weight);
                } else {
                    itemsStack.add(item - 1);
                    weightStack.add(weight);
                    itemsStack.add(item - 1);
                    weightStack.add(weight - weights[item - 1]);
                }

            }
            ++idx;
        } while (item >= 0 && weight >= 0 && itemsStack.size() > idx);

        return matrix[row - 1][col - 1];
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


}
