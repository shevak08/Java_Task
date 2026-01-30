import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        
        int strengthScore = 0;
        if (password.length() >= 8) strengthScore++;
        if (Pattern.compile("[0-9]").matcher(password).find()) strengthScore++;
        if (Pattern.compile("[a-z]").matcher(password).find()) strengthScore++;
        if (Pattern.compile("[A-Z]").matcher(password).find()) strengthScore++;
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(password).find()) strengthScore++; // Special chars

        System.out.println("Password Length: " + password.length());

        if (strengthScore >= 4) {
            System.out.println("Password Strength: **Strong**");
        } else if (strengthScore >= 2) {
            System.out.println("Password Strength: **Medium**");
        } else {
            System.out.println("Password Strength: **Weak**");
        }
        scanner.close();
    }
}
