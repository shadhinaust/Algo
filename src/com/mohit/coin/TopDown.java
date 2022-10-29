package com.mohit.coin;

import java.util.Arrays;

public class TopDown {
    public int robotCoinCollection(int[][] C) {
        int row = C.length;
        int col = C[0].length;
        int[][] F = new int[row][col];
        int[][] P = new int[row][col];
        F[0][0] = C[0][0];


        for (int c = 1; c < col; c++) {
            F[0][c] = F[0][c - 1] + C[0][c];
        }

        for (int r = 1; r < row; r++) {
            F[r][0] = F[r - 1][0] + C[r][0];
            for (int c = 1; c < col && C[r][c] != -1; c++) {
                F[r][c] = Math.max(F[r - 1][c], F[r][c - 1]) + C[r][c];
                if (F[r - 1][c] < F[r][c] && F[r][c - 1] < F[r][c]) {
                    P[r][c] = Math.max(P[r - 1][c], P[r][c - 1]) + 1;
                } else {
                    P[r][c] = Math.max(P[r - 1][c], P[r][c - 1]);
                }
            }
        }

        for (int r = 0; r < row; r++) {
            System.out.println(Arrays.toString(F[r]));
        }
        /*System.out.println();
        for (int r = 0; r < row; r++) {
            System.out.println(Arrays.toString(P[r]));
        }*/

        return F[row - 1][col - 1];
    }

    public int robotCoinCollectionWithObstacle(int[][] C) {

        int row = C.length;
        int col = C[0].length;
        int[][] F = new int[row][col];
        int[][] P = new int[row][col];
        F[0][0] = C[0][0];
/*        for (int r = 0; r < row; r++) {
            System.out.println(Arrays.toString(C[r]));
        }*/
        System.out.println();

        for (int c = 1; c < col; c++) {
            if (C[0][c] == -1) {
                F[0][c] = -1;
            } else {
                F[0][c] = F[0][c - 1] == -1 ? -1 : (F[0][c - 1] + C[0][c]);
            }

        }

        for (int r = 1; r < row; r++) {
            if (C[r][0] == -1) {
                F[r][0] = -1;
            } else {
                F[r][0] = F[r - 1][0] == -1 ? -1 : (F[r - 1][0] + C[r][0]);
            }
            for (int c = 1; c < col; c++) {
                if (C[r][c] == -1) {
                    F[r][c] = -1;
                    continue;
                }
                F[r][c] = Math.max(F[r - 1][c], F[r][c - 1]) + C[r][c];
            }
        }

        for (int r = 0; r < row; r++) {
            System.out.println(Arrays.toString(F[r]));
        }

        return F[row - 1][col - 1];
    }
}
