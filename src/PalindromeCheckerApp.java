public class PalindromeCheckerApp {

    /**
     * Checks if a string is a palindrome, ignoring case and non-alphanumeric characters.
     * * @param str The input string to check.
     * @return true if the normalized string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String str) {
        // Step 1: Normalize string using String preprocessing and Regular expressions
        // The regex "[^a-zA-Z0-9]" matches anything that is NOT a letter or a digit.
        // We replace those matches with an empty string and convert the result to lowercase.
        String normalizedStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Data Structure: Convert the normalized String to a character Array
        char[] charArray = normalizedStr.toCharArray();

        // Step 2: Apply previous logic (Two-Pointer Technique)
        int left = 0;
        int right = charArray.length - 1;

        while (left < right) {
            // Compare characters at the front and rear pointers
            if (charArray[left] != charArray[right]) {
                return false; // Mismatch found, not a palindrome
            }
            left++;
            right--;
        }

        return true; // Loop finished without mismatches; it's a palindrome
    }

    public static void main(String[] args) {
        // Test Cases
        String test1 = "A man, a plan, a canal: Panama";
        String test2 = "No 'x' in Nixon";
        String test3 = "Was it a car or a cat I saw?";
        String test4 = "Hello World";

        System.out.println("Is '" + test1 + "' a palindrome? " + isPalindrome(test1));
        System.out.println("Is '" + test2 + "' a palindrome? " + isPalindrome(test2));
        System.out.println("Is '" + test3 + "' a palindrome? " + isPalindrome(test3));
        System.out.println("Is '" + test4 + "' a palindrome? " + isPalindrome(test4));
    }
}