import java.util.Stack;

public class PalindromeCheckerApp {

    // --- Algorithm 1: Optimized Two-Pointer (O(1) Space) ---
    public static boolean isPalindromeTwoPointer(String text) {
        int left = 0;
        int right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // --- Algorithm 2: StringBuilder Reversal (O(n) Space) ---
    public static boolean isPalindromeStringBuilder(String text) {
        String reversed = new StringBuilder(text).reverse().toString();
        return text.equals(reversed);
    }

    // --- Algorithm 3: Stack-Based (O(n) Space, Higher Overhead) ---
    public static boolean isPalindromeStack(String text) {
        Stack<Character> stack = new Stack<>();
        for (char c : text.toCharArray()) {
            stack.push(c);
        }
        for (char c : text.toCharArray()) {
            if (stack.pop() != c) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Create a massive palindrome string to clearly see performance differences
        StringBuilder sb = new StringBuilder();
        sb.append("a".repeat(500000));
        sb.append("b");
        sb.append("a".repeat(500000));
        String massiveString = sb.toString();

        System.out.println("Running Performance Comparison on String length: " + massiveString.length() + "\n");

        // JVM Warm-up (Important for accurate micro-benchmarking in Java)
        isPalindromeTwoPointer(massiveString);
        isPalindromeStringBuilder(massiveString);
        isPalindromeStack(massiveString);

        // 1. Measure Two-Pointer
        long startTime = System.nanoTime();
        isPalindromeTwoPointer(massiveString);
        long endTime = System.nanoTime();
        long durationTwoPointer = (endTime - startTime) / 1_000_000; // Convert to milliseconds

        // 2. Measure StringBuilder
        startTime = System.nanoTime();
        isPalindromeStringBuilder(massiveString);
        endTime = System.nanoTime();
        long durationStringBuilder = (endTime - startTime) / 1_000_000;

        // 3. Measure Stack
        startTime = System.nanoTime();
        isPalindromeStack(massiveString);
        endTime = System.nanoTime();
        long durationStack = (endTime - startTime) / 1_000_000;

        // Display Results
        System.out.println("--- Execution Results (Milliseconds) ---");
        System.out.println("1. Two-Pointer Approach   : " + durationTwoPointer + " ms");
        System.out.println("2. StringBuilder Approach : " + durationStringBuilder + " ms");
        System.out.println("3. Stack Approach         : " + durationStack + " ms");
    }
}