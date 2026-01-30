import java.security.SecureRandom;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Random {
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String NUMBERS = "0123456789";
    private static final String SYMBOLS = "!@#$%^&*()_-+=[]{}\\|;:'\"<>,.?/";
    private static SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter desired password length: ");
        int length = scanner.nextInt();
        // Add prompts for character types here if desired
        
        System.out.println("Generated Password: " + generatePassword(length));
        scanner.close();
    }

    public static String generatePassword(int length) {
        if (length < 4) length = 4; // Ensure minimum length for diversity
        List<Character> passwordChars = new ArrayList<>();
        
        // Ensure at least one of each required character type (example implementation)
        passwordChars.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        passwordChars.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        passwordChars.add(NUMBERS.charAt(random.nextInt(NUMBERS.length())));
        passwordChars.add(SYMBOLS.charAt(random.nextInt(SYMBOLS.length())));
        
        String allChars = LOWERCASE + UPPERCASE + NUMBERS + SYMBOLS;
        // Fill the rest of the password length
        for (int i = 4; i < length; i++) {
            passwordChars.add(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle for true randomness
        Collections.shuffle(passwordChars);
        
        StringBuilder password = new StringBuilder();
        for (char c : passwordChars) {
            password.append(c);
        }
        return password.toString();
    }
}
