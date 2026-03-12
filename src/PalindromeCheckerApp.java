public class RecursivePalindrome {

    /**
     * Public method to prepare the string and initiate recursion.
     * @param str The input string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        // Pre-process the string to handle edge cases like spaces and case differences
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Initiate the recursive call with starting indices
        return checkPalindromeRecursive(cleanStr, 0, cleanStr.length() - 1);
    }

    /**
     * The core recursive method.
     */
    private static boolean checkPalindromeRecursive(String str, int left, int right) {
        // Base Condition 1: If left index crosses or equals right, we checked all pairs
        if (left >= right) {
            return true;
        }

        // Base Condition 2: If characters at current pointers don't match, it's not a palindrome
        if (str.charAt(left) != str.charAt(right)) {
            return false;
        }

        // Recursive call: Move pointers inward and call the method again
        return checkPalindromeRecursive(str, left + 1, right - 1);
    }

    public static void main(String[] args) {
        // Test Cases
        String test1 = "racecar";
        String test2 = "hello";
        String test3 = "A man, a plan, a canal: Panama";

        System.out.println("Is '" + test1 + "' a palindrome? " + isPalindrome(test1));
        System.out.println("Is '" + test2 + "' a palindrome? " + isPalindrome(test2));
        System.out.println("Is '" + test3 + "' a palindrome? " + isPalindrome(test3));
    }
}