package com.example.demo.sortingalgorithm;

public class BubbleSort {


    public static void main(String[] args) {

        int[] arr = {3, 5, 1, 2, 4};

        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(arr);

        for (int i : arr) {
            System.out.println(i);
        }
    }

    public void sort(int[] arr) {
        int n = arr.length;
        boolean swapped = false;
        for(int i=0; i< n-1; i++){
            for (int j=0; j < n-1-i; j++){

                if(arr[j] < arr[j+1]){
                    int temp = arr[j+1];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }

                if(!swapped){
                    break;
                }
            }
        }
    }
}
