import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Create a linked list with elements "apple", "banana", and "cherry"
        LinkedList<String> fruits = new LinkedList<>();

        // Add elements to the list
        fruits.add("apple");
        fruits.add("banana");
        fruits.add("cherry");

        // Print the original list
        System.out.println("Original List: " + fruits);

        // Add "orange" to the beginning of the list
        fruits.addFirst("orange");

        // Print the list after adding "orange"
        System.out.println("List after adding 'orange': " + fruits);

        // Remove an element from the list (at index 2)
        fruits.remove(2);

        // Print the list after removing an element
        System.out.println("List after removing an element: " + fruits);

        // Get an element at a specific index (index 1)
        String element = fruits.get(1);
        System.out.println("Element at index 1: " + element);

        // Print the size of the list
        int size = fruits.size();
        System.out.println("Size of the list: " + size);
    }
}
