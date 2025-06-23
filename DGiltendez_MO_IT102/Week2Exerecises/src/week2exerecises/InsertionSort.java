/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2exerecises;

/**
 *
 * @author danilo
 */
import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        // Input array of integers
        int[] arr = {5, 2, 4, 6, 1, 3,7};

        // Call the insertionSort function to sort the array
        insertionSort(arr);

        // Output: print the sorted array
        System.out.println(Arrays.toString(arr));  // Output: [1, 2, 3, 4, 5, 6]
    }

    // Function to sort an array using the insertion sort algorithm
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Loop through the array starting from the second element
        for (int i = 1; i < n; i++) {
            // Store the current element as key
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place the key in its correct position
            arr[j + 1] = key;
        }
    }
}
