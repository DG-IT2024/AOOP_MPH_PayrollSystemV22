
package week2exerecises;
import java.util.Arrays;

public class BubbleSort {

    // Function to sort an array of integers in ascending order using the bubble sort algorithm
    public static int[] bubbleSort(int[] arr) {
        // Get the length of the input array
        int n = arr.length;

        // Outer loop to iterate over the array elements
        for (int i = 0; i < n - 1; i++) {
            // Inner loop to compare adjacent elements and swap them if they are out of order
            for (int j = 0; j < n - i - 1; j++) {
                // Swap adjacent elements if they are in the wrong order
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        // Return the sorted array
        return arr;
    }

    // Function to print an array of integers to the console
    public static void printArray(int[] arr) {
        // Loop to print each element of the array to the console
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    // Main program
    public static void main(String[] args) {
        // Input array of integers to be sorted
        int[] arr = {5, 3, 8, 4, 2};

        // Sort the input array using the bubble sort algorithm
        int[] sortedArr = bubbleSort(arr);

        // Print the sorted array to the console
        System.out.println("Sorted array:");
        printArray(sortedArr);
    }
}
