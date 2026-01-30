import java.util.*;

public class ATM {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int balance = 50000;
        boolean running = true;

        while ( running) {
            System.out.println("1) Deposit");
            System.out.println("2) Withdraw");
            System.out.println("3) Balance Enquiry");
            System.out.println("4) Exit");
            System.out.print("Choose an option: ");
 
            int choice = in.nextInt();

            switch (choice) {
                case 1 -> { 
                    System.out.print("Enter amount to deposit: ");
                    int depositAmount = in.nextInt();
                    if (depositAmount >= 500 && depositAmount <= 10000) {
                        balance += depositAmount;
                        System.out.println("Deposited: Rs" + depositAmount);
                    } else {
                        System.out.println("Invalid deposit amount.");
                    }
                }

                case 2 -> {
                    System.out.print("Enter amount to withdraw: ");
                    int withdrawAmount = in.nextInt();
                    if (withdrawAmount >= 100 && withdrawAmount <= balance) {
                        balance -= withdrawAmount;
                        System.out.println("Withdrawn: Rs" + withdrawAmount);
                    } else if (withdrawAmount > balance) {
                        System.out.println("Insufficient balance.");
                    } else {
                        System.out.println("Invalid withdrawal amount.");
                    }
                }

                case 3 -> System.out.println("Current balance: Rs" + balance);

                case 4 -> { 
                    System.out.println("Exiting ATM. Thank you!");
                    running = false;
                }

                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

        in.close();
    }
}
