/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author danilo
 */

import java.util.Arrays;

public class ArraySum {
    public static void main(String[] args) {
        int[] arr = {254, 16, 9, 10};

        // Calculate the sum using the built-in Arrays.stream() method for efficiency
        int sum = Arrays.stream(arr).sum();

        System.out.println("The sum of the array's values is: " + sum);
    }
}
