package com.mohit.dp;

public interface KnapsackSolution {
    int getOptimalValue(int[] values, int[] weights, int capacity);

    int getOptimalValueByIterative(int[] values, int[] weights, int capacity);
}
