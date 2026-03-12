import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeCheckerApp {

    /**
     * Checks if a given string is a palindrome using a Deque.
     * * @param str The input string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        // Step 1: Pre-process the string (optional but recommended)
        // Convert to lowercase and remove non-alphanumeric characters for accurate checking
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initialize the Deque (ArrayDeque is highly optimized for this)
        Deque<Character> deque = new ArrayDeque<>();

        // Step 2: Insert characters into deque
        for (char c : cleanStr.toCharArray()) {
            deque.addLast(c);
        }

        // Step 3: Remove first & last, Compare until empty (or 1 element left)
        while (deque.size() > 1) {
            // Front and Rear Access
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            // Compare elements
            if (front != rear) {
                return false; // Mismatch found, not a palindrome
            }
        }

        // Optimized Data Handling: If the loop finishes without mismatches, it's a palindrome
        return true;
    }

    public static void main(String[] args) {
        // Test Cases
        String test1 = "racecar";
        String test2 = "hello";
        String test3 = "A man, a plan, a canal: Panama"; // Testing with spaces and punctuation

        System.out.println("Is '" + test1 + "' a palindrome? " + isPalindrome(test1));
        System.out.println("Is '" + test2 + "' a palindrome? " + isPalindrome(test2));
        System.out.println("Is '" + test3 + "' a palindrome? " + isPalindrome(test3));
    }
}