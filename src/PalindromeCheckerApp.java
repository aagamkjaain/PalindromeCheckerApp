import java.util.Scanner;

class PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        char[] arr = str.toCharArray();

        int start = 0;
        int end = arr.length - 1;
        boolean isPalindrome = true;

        while(start < end)
        {
            if(arr[start] != arr[end])
            {
                isPalindrome = false;
                break;
            }

            start++;
            end--;
        }

        if(isPalindrome)
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not Palindrome");
        }
    }
}
