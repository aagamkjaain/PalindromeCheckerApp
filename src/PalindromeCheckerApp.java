import java.util.Scanner;
import java.util.Stack;

class UseCase5PalindromeCheckerApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for(int i = 0; i < str.length(); i++)
        {
            stack.push(str.charAt(i));
        }

        String reversed = "";

        // Pop characters from stack
        while(!stack.isEmpty())
        {
            reversed = reversed + stack.pop();
        }

        if(str.equals(reversed))
        {
            System.out.println("Palindrome");
        }
        else
        {
            System.out.println("Not Palindrome");
        }
    }
}
