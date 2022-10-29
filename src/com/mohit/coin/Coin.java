package com.mohit.coin;

import java.util.ArrayList;
import java.util.List;

public class Coin {
    public static void main(String[] args) {
        /*int[] C = new int[]{5, 1, 2, 10, 6, 2};
        BottomUp bottomUp = new BottomUp();
        System.out.println(bottomUp.getMaxAmount(C));*/

        int[][] C1 = {
                {0, -1, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, -1},
                {-1, 0, -1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, -1, 0},
                {1, 1, 0, 0, -1, 0}
        };
        /*
        TopDown topDown = new TopDown();
        System.out.println(topDown.robotCoinCollectionWithObstacle(C1));
        */
        System.out.println(isPowerOfThree(243));
    }


    public static boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3,19) % n == 0;
    }
}
