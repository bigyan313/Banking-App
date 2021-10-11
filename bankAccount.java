package bank;
import java.io.*;
// Base class
// Abstract
public abstract class bankAccount {

    // bankAccount number attribute
    private int bankAccountNumber;

    // bankBalance attribute
    protected double bankBalance;

    // Default constructor
    public bankAccount() {

    }

    public bankAccount(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        bankBalance = 0;
    }

    // Getter methods for bankBalance and bankAccountNumber
    public double getBankBalance() {
        return this.bankBalance;
    }

    public int getBankAccountNumber() {
        return this.bankAccountNumber;
    }

    // Abstracts
    /**
     * Deposit function
     * Cant deposit negative funds
     */
    public abstract void deposit(double amount);

    /**
     * Withdraw Function
     * Cant withdraw negative amount and insufficient amount
     */
    public abstract void withdraw(double amount);
}
