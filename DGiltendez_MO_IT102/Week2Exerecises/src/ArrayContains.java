

public class ArrayContains {

    public static void main(String[] args) {
        int[] arr = {3, 7, 12, 6, 18}; // Declare and initialize the array with five elements
        int valueToCheck = 6; // The value we want to check if it's in the array

        boolean containsValue = false; // Initialize a boolean variable to keep track if the value is found

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == valueToCheck) { // Check if the current element of the array is equal to the value we want to check
                containsValue = true; // If the value is found, set the boolean variable to true
                break; // Break out of the loop since we don't need to check the rest of the elements
            }
        }

        if (containsValue) { // Check the boolean variable to see if the value was found
            System.out.println("The array contains the value " + valueToCheck);
        } else {
            System.out.println("The array does not contain the value " + valueToCheck); 

        }
    }
}