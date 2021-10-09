package bank;
import java.util.Scanner;

public class AccountDriver {

    // Program Start
    public static void main(String [] args) {

        Scanner userKeyboard = new Scanner(System.in);

        // Creating Accounts Lists
        bankAccount accounts [] = new bankAccount[10];
        int numberAccounts = 0;

        int userChoice;

        do {
            userChoice = bankMenu(userKeyboard);
            System.out.println();

            if(userChoice == 1) {
                accounts[numberAccounts++] = createAccount(userKeyboard);
            } else if(userChoice == 2) {
                makeDeposit(accounts, numberAccounts, userKeyboard);
            } else if(userChoice == 3) {
                doWithdraw(accounts, numberAccounts, userKeyboard);
            } else if(userChoice == 4) {
                applyInterest(accounts, numberAccounts, userKeyboard);
            } else {
                System.out.println("Bye Thank you for using Bank App!");
                System.out.println("emial bigyan.adhikari313@gmail.com for service");
            }
            System.out.println();
        } while(userChoice != 5);
    }

    /**
     *promt for bank account selection
     */
    public static int accountMenu(Scanner userKeyboard) {
        System.out.println("Select Account Type");
        System.out.println("1. Checking Acc");
        System.out.println("2. Savings Acc");

        int userChoice;
        do {
            System.out.print("Enter a Choice below: (1-2) ");
            userChoice = userKeyboard.nextInt();
        }while(userChoice < 1 || userChoice > 2);

        return userChoice;
    }

    public static int searchAccount(bankAccount accounts [], int count, int bankAccountNumber) {

        for(int i=0; i<count; i++) {
            if(accounts[i].getBankAccountNumber() == bankAccountNumber) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Function to perform Deposit on a selected bankAccount
     */
    public static void makeDeposit(bankAccount accounts [], int count, Scanner userKeyboard) {
        // Get the bankAccount number
        System.out.print("\nPlease enter your Account number: ");
        int bankAccountNumber = userKeyboard.nextInt();

        // search for bank account
        int index = searchAccount(accounts, count, bankAccountNumber);

        if(index >= 0) {

            System.out.print("Please enter Deposit Amount: ");
            double amount = userKeyboard.nextDouble();

            accounts[index].deposit(amount);
        } else {
            System.out.println("No Account exist with bankAccountNumber: " + bankAccountNumber);
        }
    }

    public static void doWithdraw(bankAccount accounts [], int count, Scanner userKeyboard) {
        // Getting the bank account number
        System.out.print("\nPlease enter your Account number: ");
        int bankAccountNumber = userKeyboard.nextInt();

        // search for a bank account
        int index = searchAccount(accounts, count, bankAccountNumber);

        if(index >= 0) {
            // Amount
            System.out.print("Please enter Amount to Withdraw: ");
            double amount = userKeyboard.nextDouble();
            accounts[index].withdraw(amount);
        } else {
            System.out.println("No Account exist with Account Number: " + bankAccountNumber);
        }
    }

    public static void applyInterest(bankAccount accounts [], int count, Scanner userKeyboard) {
        // Get the bank  number
        System.out.print("\nPlease enter your Account number: ");
        int bankAccountNumber = userKeyboard.nextInt();

        // search for bank acc
        int index = searchAccount(accounts, count, bankAccountNumber);

        if(index >= 0) {

            // must be an  instance of savings bankAccount
            if(accounts[index] instanceof savingsaccount) {
                ((savingsaccount)accounts[index]).applyInterest();
            }
        } else {
            System.out.println("No Account exist with Account Number: " + bankAccountNumber);
        }
    }

    /**
     * Function to create a new bankAccount
     */
    public static bankAccount createAccount(Scanner userKeyboard) {

        bankAccount bankAccount = null;
        int userChoice = accountMenu(userKeyboard);

        int bankAccountNumber;
        System.out.print("Enter Account Number: ");
        bankAccountNumber = userKeyboard.nextInt();

        if(userChoice == 1)  { // chekcing bankAccount
            System.out.print("Enter Transaction Fee: ");
            double fee = userKeyboard.nextDouble();
            bankAccount = new CheckingAccount(bankAccountNumber, fee);
        } else { // Savings bankAccount

            System.out.print("Please enter Interest Rate: ");
            double ir = userKeyboard.nextDouble();
            bankAccount = new SavingsAccount(bankAccountNumber, ir);
        }
        return bankAccount;
    }

    /**
     * bankMenu to display options and get the user's selection
     *
     * @param userKeyboard
     * @return userChoice
     */
    public static int bankMenu(Scanner userKeyboard) {
        System.out.println("Bank Account User Menu");

        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int userChoice;

        do {
            System.out.print("Enter your Choice: ");
            userChoice = userKeyboard.nextInt();
        } while(userChoice < 1 || userChoice > 5);

        return userChoice;
    }
}
