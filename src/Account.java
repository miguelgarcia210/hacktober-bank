import java.rmi.activation.ActivationGroup_Stub;
import java.util.Random;
import java.util.Scanner;

public class Account {
    // Class Variables
    int balance;
    int previousTransaction;
    int creditScore;
    int loanEstimate;
    String customerName;
    String customerID;

    // Class Constructor
    Account (String cname, String cid) {
        customerName = cname;
        customerID = cid;
    }

    // Function for Depositing money
    void deposit (int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw (int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    // Function showing the previous transaction
    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction occurred");
        }
    }

    // Function calculating interest of current funds after a number of years
    void calculateInterest(int years) {
        double interestRate = .0185;
        double newBalance = (balance * interestRate * years) + balance;
        System.out.println("The current interest rate is " + (100 * interestRate) + "%");
        System.out.println("After " + years + " years, you balance will be: " + newBalance);
    }

    // Function based on the users luck
    void calculateLuck() {
        Random random = new Random();
        int lucky = random.nextInt(10);

        if (lucky > 0 && lucky <= 5) {
            System.out.println("You've just earned $100");
            deposit(100);
        } else {
            System.out.println("You've lost $50. Try again next time");
            withdraw(50);
        }
    }

    // Function based on users credit
    void checkCredit() {
        Random random = new Random();
        creditScore = random.nextInt(850);
    }

    // Function based on loan estimate
    void loanEstimator() {
        Random random = new Random();
        loanEstimate = random.nextInt(35000);
    }

    // Function showing the main menu
    void showMenu() {
        char option = '\0';
        Scanner scanner = new Scanner (System.in);
        System.out.println("Welcome, " + customerName + "!");
        System.out.println("Your ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("A. Check your balance");
        System.out.println("B. Make a deposit");
        System.out.println("C. Make a withdrawal");
        System.out.println("D. View previous transaction");
        System.out.println("E. Calculate interest");
        System.out.println("F. Exit");
        System.out.println("G. Test you luck");
        System.out.println("H. Check Credit Score");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            char option1 = scanner.next().charAt(0);
            option = Character.toUpperCase(option1);
            System.out.println();

            switch (option) {
                // Case 'A' allows the user to check their account balance
                case 'A':
                    System.out.println("===================================");
                    System.out.println("Balance = $" + balance);
                    System.out.println("===================================");
                    System.out.println();
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit: ");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println();
                    break;
                    //Case 'C' allows the user to withdraw money from their account using the 'Withdraw' function
                case 'C':
                    System.out.println("Enter an amount to withdraw: ");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println();
                    break;
                    // Case 'D' allows the user to view their most recent transaction using the 'getPreviousTransaction' function
                case 'D':
                    System.out.println("===================================");
                    getPreviousTransaction();
                    System.out.println("===================================");
                    System.out.println();
                    break;
                    // Case 'E' calculates the accrued interest on the account after a number of years specified by the user
                case 'E':
                    System.out.println("Enter how many years of accrued interest: ");
                    int years = scanner.nextInt();
                    calculateInterest(years);
                    break;
                    // Case 'F' exits the user from their account
                case 'F':
                    System.out.println("===================================");
                    break;
                case 'G':
                    System.out.println("===================================");
                    calculateLuck();
                    System.out.println("===================================");
                    System.out.println();
                    break;
                case 'H':
                    checkCredit();
                    System.out.println("===================================");
                    System.out.println("Credit Score = " + creditScore);
                    System.out.println("===================================");
                    System.out.println();
                    break;
                case 'I':
                    loanEstimator();
                    System.out.println("===================================");
                    System.out.println("Pre-Approval Amount = " + loanEstimate);
                    System.out.println("===================================");
                    System.out.println();
                    break;
                    // The default case let's the user know that they entered an invalid and how to enter a valid one
                default:
                    System.out.println("Error: invalid option. Please enter A, B, C, D, E, or F");
                    break;
            }
        } while (option != 'F');
        System.out.println("Thank you for banking with us!");
    }
}
