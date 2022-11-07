package com.mohit.schedule;

public class Greedy {
    public int[] earliestStart(int[] a, int[] b) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int[] result = new int[a.length + 1];

        /*while (true) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] < start && b[i] < ) {

                }
            }
        }*/

        return result;
    }

    public int[] shortestDuration(int[] a, int[] b) {
        return null;
    }

    public int[] earliestFinish(int[] a, int[] b) {
        return null;
    }

    private void sort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
