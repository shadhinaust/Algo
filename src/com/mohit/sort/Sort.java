package com.mohit.sort;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Sort {
    private static final int[] K = new int[]{2, 4, 8, 16, 19, 25, 27, 30, 36, 42, 49, 51, 58, 64, 67, 71, 76, 84, 89, 93, 99};
    //private static final int[] K = new int[]{2, 9, 15, 21, 25, 29, 35, 42, 50, 61, 65, 70, 75, 82, 85, 93, 98};
    //private static final int[] K = new int[]{2, 3, 4, 5, 6, 8, 16, 25, 27, 32, 64, 75, 81};
    // private static final int[] K = new int[]{2, 4, 8, 16, 32, 64, 3, 27, 81, 5, 25, 75, 6};

    private static final int LEN[] = new int[]{50000, 250000, 450000, 650000, 850000, 1000000};

    //private static final int LEN[] = new int[]{50000, 250000, 450000, 650000, 850000, 1000000};
    //private static final int LEN[] = new int[]{500000, 2500000, 4500000, 6500000, 8500000, 10000000};
    // private static final int LEN[] = new int[]{580000, 1160000, 1740000, 2320000, 2900000, 3480000};
    private static final int TRACE = 200;

    public static void main(String[] args) {
        testIfCorrect();
        unsortedAvgTime();
        sortedAvgTime();
    }

    private static void testIfCorrect() {
        int trace = 10;
        HybridSort hybridSort = new HybridSort();
        boolean isPerfect = true;
        for (int i = 0; i < trace; i++) {
            Random random = new Random();
            int len = random.nextInt(10000000 - 200000) + 200000;
            int[] arr = new int[len];
            int[] comp = new int[len];
            for (int j = 0; j < len; j++) {
                arr[j] = comp[j] = random.nextInt(200 - (-100)) + (-100);
            }
            System.out.println("Trace " + i);
            for (int k : K) {
                hybridSort.sort(arr, k);
                Arrays.sort(comp);
                boolean isSorted = Arrays.equals(arr, comp);
                System.out.print("K=" + k + ", R=" + isSorted + "; ");
                isPerfect = isPerfect && isSorted;
            }
            System.out.println("\n");
        }
        System.out.println("Overall correctness: " + isPerfect);

    }

    private static void unsortedAvgTime() {
        Random random = new Random();
        int numOfArrays = LEN.length;
        int numOfKs = K.length;

        List<int[]> arraysList = new ArrayList<>();

        for (int value : LEN) {
            int start = 101;
            int[] numbers = new int[value];
            for (int j = 0; j < value; j++) {
                numbers[j] = random.nextInt(value - start) + start;
            }
            arraysList.add(numbers);
        }

        Instant start, end;
        long TT;

        HybridSort hybridSort = new HybridSort();
        System.out.println("K=" + Arrays.toString(K));
        for (int i = 0; i < numOfArrays; i++) {
            long[] avgTime = new long[numOfKs];
            for (int j = 0; j < numOfKs; j++) {
                TT = 0;
                for (int k = 0; k < TRACE; k++) {
                    int[] numbers = new int[LEN[i]];
                    System.arraycopy(arraysList.get(i), 0, numbers, 0, LEN[i]);

                    start = Instant.now();
                    hybridSort.sort(numbers, K[j]);
                    end = Instant.now();
                    TT = TT + Duration.between(start, end).toNanos();

                    /*
                    int[] comparator = new int[LEN[i]];
                    System.arraycopy(arraysList.get(i), 0, comparator, 0, LEN[i]);Arrays.sort(comparator);
                    if (!Arrays.equals(numbers, comparator)) {
                        System.out.print(" " + false);
                    }
                    */
                }
                avgTime[j] = TT / TRACE;
            }
            System.out.println("\nFor n=" + LEN[i] + ", t=" + Arrays.toString(avgTime));
        }
    }

    private static void sortedAvgTime() {
        int numOfArrays = LEN.length;
        int numOfKs = K.length;

        List<int[]> arraysList = new ArrayList<>();

        for (int value : LEN) {
            int[] numbers = new int[value];
            for (int j = 0; j < value; j++) {
                numbers[j] = j + 1;
            }
            arraysList.add(numbers);
        }

        Instant start, end;
        long TT;

        HybridSort hybridSort = new HybridSort();
        System.out.println("K=" + Arrays.toString(K));
        for (int i = 0; i < numOfArrays; i++) {
            long[] avgTime = new long[numOfKs];
            for (int j = 0; j < numOfKs; j++) {
                TT = 0;
                for (int k = 0; k < TRACE; k++) {
                    int[] numbers = new int[LEN[i]];
                    System.arraycopy(arraysList.get(i), 0, numbers, 0, LEN[i]);

                    start = Instant.now();
                    hybridSort.sort(numbers, K[j]);
                    end = Instant.now();
                    TT = TT + Duration.between(start, end).toNanos();

                    /*
                    int[] comparator = new int[LEN[i]];
                    System.arraycopy(arraysList.get(i), 0, comparator, 0, LEN[i]);Arrays.sort(comparator);
                    if (!Arrays.equals(numbers, comparator)) {
                        System.out.print(" " + false);
                    }
                    */
                }
                avgTime[j] = TT / TRACE;
            }
            System.out.println("\nFor n=" + LEN[i] + ", t=" + Arrays.toString(avgTime));
        }
    }
}
