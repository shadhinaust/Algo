package com.mohit.sort;

public class HybridSort {
    private void insertionSort(int[] A, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int key = A[i];
            int j = i - 1;
            while (j >= left && key < A[j]) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    private void merge(int[] A, int left, int mid, int right) {
        int leftLen = mid - left + 1, rightLen = right - mid;
        int[] leftA = new int[leftLen], rightA = new int[rightLen];
        for (int i = 0; i < leftLen; i++) {
            leftA[i] = A[i + left];
        }
        for (int i = 0; i < rightLen; i++) {
            rightA[i] = A[i + mid + 1];
        }

        int i = 0, j = 0, k = left;

        while (i < leftLen && j < rightLen) {
            if (leftA[i] <= rightA[j]) {
                A[k] = leftA[i];
                i++;
            } else {
                A[k] = rightA[j];
                j++;
            }
            k++;
        }
        while (i < leftLen) {
            A[k] = leftA[i];
            i++;
            k++;
        }

        while (j < rightLen) {
            A[k] = rightA[j];
            j++;
            k++;
        }
    }

    private void sortHelper(int[] A, int left, int right, int K) {
        int len = right - left + 1;
        if (K >= 1 && len < K) {
            insertionSort(A, left, right);
        } else {
            int mid = left + ((right - left) / 2);
            sortHelper(A, left, mid, K);
            sortHelper(A, mid + 1, right, K);
            merge(A, left, mid, right);
        }
    }

    public void sort(int[] A, int K) {
        sortHelper(A, 0, A.length - 1, 6);
    }
}
