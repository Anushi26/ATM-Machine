import java.util.Scanner;

class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        this.balance = initialBalance;
        this.pin = pin;
    }

    // Verify PIN
    public boolean verifyPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void checkBalance() {
        System.out.println("Your current balance: Rs." + balance);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited Rs." + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn Rs." + amount);
            checkBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }
}

public class ATMSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for initial balance
        System.out.print("Enter the initial amount: ");
        double ib = sc.nextDouble();

        // Ask for 4-digit PIN
        System.out.print("Set a 4-digit PIN: ");
        int pin = sc.nextInt();

        // Check if pin has exactly 4 digits
        if (pin < 1000 || pin > 9999) {
            System.out.println("❌ Wrong PIN entered. Must be 4 digits.");
            return; // exit program
        }

        // Create ATM object
        ATM atm = new ATM(ib, pin);

        // Ask user to enter PIN again for login
        System.out.print("Enter your PIN to login: ");
        int enteredPin = sc.nextInt();

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("❌ Incorrect PIN. Exiting...");
            return;
        }

        // Menu-driven ATM
        int choice;
        do {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdraw amount: ");
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("✅ Thank you for using the ATM!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}
