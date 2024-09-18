import java.util.*;

public class BalancedParentheses {

    public static boolean isBalanced(String parentheses) {
        // Create a stack to keep track of opening parentheses
        Stack<Character> stack = new Stack<>();

        // Loop through each character in the string
        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            // If the character is an opening parenthesis, push it onto the stack
            if (c == '(') {
                stack.push(c);
            } 
            // If the character is a closing parenthesis, check if the stack is empty
            // or if the top of the stack is a matching opening parenthesis
            else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }

        // After looping through all characters, if the stack is empty, the parentheses are balanced
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Test cases
        String parentheses1 = "((()))";
        String parentheses2 = "()()";
        String parentheses3 = "(";
        String parentheses4 = ")";

        // Check if each string of parentheses is balanced and print the result
        System.out.println(isBalanced(parentheses1)); // true
        System.out.println(isBalanced(parentheses2)); // true
        System.out.println(isBalanced(parentheses3)); // false
        System.out.println(isBalanced(parentheses4)); // false
    }
}
