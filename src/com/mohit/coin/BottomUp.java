package com.mohit.coin;

public class BottomUp {

    /*
     * this function return the maximum amount of money from the coin row without taking two adjacent coin.
     * input: Array of coins
     * output: maximum amount of money
     */
    public int getMaxAmount(int[] C) {
        int[] F = new int[C.length + 1];
        F[0] = 0;
        F[1] = C[0];
        for (int i = 2; i <= C.length; i++) {
            F[i] = Math.max((C[i - 1] + F[i - 2]), F[i - 1]);
        }
        return F[C.length];
    }
}
