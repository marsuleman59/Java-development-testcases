package com.example.demo.sorting;

import java.util.Arrays;

public class MergeSortExample {

    // Method to perform Merge Sort on an array
    public static void mergeSort(int[] array) {
        if (array.length < 2) {
            return;  // Base case: if the array has one or zero elements, it is already sorted
        }

        // Split the array into two halves
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);

        // Recursively sort each half
        mergeSort(left);
        mergeSort(right);

        // Merge the sorted halves
        merge(array, left, right);
    }

    // Method to merge two sorted sub-arrays into the original array
    public static void merge(int[] array, int[] left, int[] right) {
        int i = 0;  // Index for left array
        int j = 0;  // Index for right array
        int k = 0;  // Index for original array

        // Merge elements from left and right arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array (if any)
        while (i < left.length) {
            array[k++] = left[i++];
        }

        // Copy remaining elements from right array (if any)
        while (j < right.length) {
            array[k++] = right[j++];
        }
    }

    // Main method to test the Merge Sort
    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};  // Example array
        System.out.println("Original array: " + Arrays.toString(array));

        mergeSort(array);  // Perform Merge Sort

        System.out.println("Sorted array: " + Arrays.toString(array));
    }
}

