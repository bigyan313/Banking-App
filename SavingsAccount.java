package bank;
import java.io.*;

public class SavingsAccount extends bankAccount {

 // bank interest rate
 private double interestRate;

 // default constructor
 public SavingsAccount() {
     super();
 }

 //initalizing a saving account with an interest rate
 public SavingsAccount(int bankAccountNumber, double interestRate) {
     super(bankAccountNumber);
     this.interestRate = interestRate;
 }


 public double getInterestRate() {
     return this.interestRate;
 }

 public void setInterestRate(double interestRate) {
     this.interestRate = interestRate;
 }

 public double calcInterest() {
     return bankBalance * interestRate;
 }

 public void applyInterest() {
     double interest = calcInterest();
     System.out.printf("Interest amount %.2f added to bankBalance%n", interest);
     deposit(interest);
 }

 public void deposit(double amount) {

     // case handling
     if (amount > 0) {
         bankBalance += amount;
         System.out.printf("Amount %.2f deposited%n", amount);
         System.out.printf("Current bankBalance is: %.2f%n", bankBalance);

     } else {
         System.out.println("A negative amount cannot be deposited");
     }
 }

 public void withdraw(double amount) {

     // Same check
     if (amount > 0) {
         // Check sufficient bank nalance
         if ((amount) <= bankBalance) {
             System.out.printf("Amount of %.2f withdrawn from bankAccount%n", amount);
             bankBalance -= amount;
             System.out.printf("Current bankBalance is: %.2f%n", bankBalance);
         }
     } else {
         System.out.println("Negative amount cannot be withdrawn!");
     }
 }
}
