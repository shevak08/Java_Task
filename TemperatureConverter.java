import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter unit (C for Celsius, F for Fahrenheit): ");
        char unit = scanner.next().charAt(0);
        double convertedTemperature;

        if (unit == 'C' || unit == 'c') {
            convertedTemperature = (temperature * 9/5) + 32;
            System.out.println(temperature + " Celsius is " + convertedTemperature + " Fahrenheit.");
        } else if (unit == 'F' || unit == 'f') {
            convertedTemperature = (temperature - 32) * 5/9;
            System.out.println(temperature + " Fahrenheit is " + convertedTemperature + " Celsius.");
        } else {
            System.out.println("Invalid unit entered.");
        }
        scanner.close();
    }
}
