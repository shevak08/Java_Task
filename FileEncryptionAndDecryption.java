import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileEncryptionAndDecryption {

    private static final int SHIFT = 4; // Simple Caesar Cipher key

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the file name or path: ");
        String inputFilePath = scanner.nextLine();

        System.out.print("Do you want to encrypt or decrypt the file? (e/d): ");
        char choice = scanner.next().toLowerCase().charAt(0);

        try {
            processFile(inputFilePath, choice);
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static void processFile(String inputPathStr, char choice) throws IOException {
        Path inputPath = Paths.get(inputPathStr);
        
        // Check if file exists before processing
        if (!Files.exists(inputPath)) {
            throw new FileNotFoundException("The system cannot find the file specified: " + inputPathStr);
        }

        // Fix: Use getParent() and getFileName() to avoid invalid Windows path syntax
        Path directory = inputPath.getParent();
        String fileName = inputPath.getFileName().toString();
        
        String prefix = (choice == 'e') ? "encrypted_" : "decrypted_";
        String outputFileName = prefix + fileName;
        
        // Resolve the new file in the same directory as the original
        Path outputPath = (directory != null) ? directory.resolve(outputFileName) : Paths.get(outputFileName);

        String content = Files.readString(inputPath);
        String result = (choice == 'e') ? encrypt(content) : decrypt(content);

        Files.writeString(outputPath, result);
        System.out.println("Success! File saved to: " + outputPath.toAbsolutePath());
    }

    private static String encrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                result.append((char) ((character - base + SHIFT) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    private static String decrypt(String text) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isUpperCase(character) ? 'A' : 'a';
                // Subtract shift and add 26 to handle negative wrap-around
                result.append((char) ((character - base - SHIFT + 26) % 26 + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }
}
