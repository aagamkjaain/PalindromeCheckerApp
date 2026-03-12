public class PalindromeCheckerApp {

    // Singly Linked List Node definition
    static class ListNode {
        char val;
        ListNode next;

        ListNode(char val) {
            this.val = val;
            this.next = null;
        }
    }

    /**
     * Helper method: Step 1 - Convert string to linked list
     */
    public static ListNode stringToList(String str) {
        String cleanStr = str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        if (cleanStr.isEmpty()) return null;

        ListNode head = new ListNode(cleanStr.charAt(0));
        ListNode current = head;

        // Node Traversal: Sequential access to build the list
        for (int i = 1; i < cleanStr.length(); i++) {
            current.next = new ListNode(cleanStr.charAt(i));
            current = current.next;
        }
        return head;
    }

    /**
     * Core logic to check if the linked list is a palindrome
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Fast and Slow Pointer Technique to find the middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // Moves 1 step
            fast = fast.next.next;    // Moves 2 steps
        }

        // Step 2: In-Place Reversal of the second half
        ListNode secondHalfHead = reverseList(slow);

        // Step 3: Compare halves
        ListNode p1 = head;
        ListNode p2 = secondHalfHead;
        boolean isPalin = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalin = false;
                break; // Mismatch found
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional best practice: Restore the list back to its original state here
        // reverseList(secondHalfHead);

        return isPalin;
    }

    /**
     * Helper method to reverse a linked list in-place
     */
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    public static void main(String[] args) {
        // Test Cases
        String[] testStrings = {"racecar", "hello", "A man, a plan, a canal: Panama"};

        for (String test : testStrings) {
            ListNode head = stringToList(test);
            System.out.println("Is '" + test + "' a palindrome? " + isPalindrome(head));
        }
    }
}