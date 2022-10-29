package com.mohit.distance;

public class LevenshteinDistance {
    public int findMinDistance(String a, String b) {
        int row = b.length() + 1;
        int col = a.length() + 1;

        int[][] minMatrix = new int[row][col];
        minMatrix[0][0] = 0;
        for (int r = 1; r < row; r++) {
            minMatrix[r][0] = r;
        }
        for (int c = 1; c < col; c++) {
            minMatrix[0][c] = c;
        }

        for (int r = 1; r < row; r++) {
            for (int c = 1; c < col; c++) {
                if (a.charAt(c - 1) == b.charAt(r - 1)) {
                    minMatrix[r][c] = minMatrix[r - 1][c - 1];
                } else {
                    minMatrix[r][c] = 1 + Math.min(Math.min(minMatrix[r - 1][c], minMatrix[r][c - 1]), minMatrix[r - 1][c - 1]);
                }
            }
        }

        return minMatrix[row - 1][col - 1];
    }

}