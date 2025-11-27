 // lab02_Q2.java
import java.util.Scanner;

class ATMMachine {
    private int accountId;
    private double balance;

    // Constructor
    public ATMMachine(int accountId, double initialDeposit) {
        this.accountId = accountId;
        this.balance = initialDeposit;
    }

    public int getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: Rs." + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: Rs." + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }
}


public class lab02_Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize 5 accounts with Rs.1000 each
        ATMMachine[] accounts = new ATMMachine[5];
        accounts[0] = new ATMMachine(12345, 1000);
        accounts[1] = new ATMMachine(23456, 1000);
        accounts[2] = new ATMMachine(34567, 1000);
        accounts[3] = new ATMMachine(45678, 1000);
        accounts[4] = new ATMMachine(56789, 1000);

        boolean exit = false;

        while (!exit) {
            System.out.print("\nEnter Account id: ");
            int enteredId = sc.nextInt();

            // Find account by id
            ATMMachine currentAccount = null;
            for (ATMMachine acc : accounts) {
                if (acc.getAccountId() == enteredId) {
                    currentAccount = acc;
                    break;
                }
            }

            if (currentAccount == null) {
                System.out.println("Account not found!");
                continue; // ask again
            }

            boolean anotherAccount = false;

            // Menu loop
            while (!anotherAccount) {
                System.out.println("\nMenu:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. Enter another account");
                System.out.println("5. Exit");
                System.out.print("Select Option number: ");

                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter Amount to deposit: ");
                        double depAmount = sc.nextDouble();
                        currentAccount.deposit(depAmount);
                        break;
                    case 2:
                        System.out.print("Enter Amount to withdraw: ");
                        double withAmount = sc.nextDouble();
                        currentAccount.withdraw(withAmount);
                        break;
                    case 3:
                        System.out.println("Balance: Rs." + currentAccount.getBalance());
                        break;
                    case 4:
                        anotherAccount = true; // break inner loop, go to outer loop
                        break;
                    case 5:
                        anotherAccount = true;
                        exit = true; // exit program completely
                        break;
                    default:
                        System.out.println("Invalid option! Please select again.");
                }
            }
        }

        sc.close();
        System.out.println("Thank you for using ATM!");
    }
}
// C:\Users\ANUJA\Desktop\VS codes\book-movie-muse