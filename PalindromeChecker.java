import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word or phrase: ");
        String input = scanner.nextLine();
   
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reverseStr = "";
        int strLength = cleaned.length();

        for (int i = (strLength - 1); i >= 0; --i) {
            reverseStr = reverseStr + cleaned.charAt(i);
        }

        if (cleaned.equals(reverseStr)) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is not a Palindrome.");
        }
        scanner.close();
    }
}
