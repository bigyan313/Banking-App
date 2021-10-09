
package bank;
//Checking bankAccount
public class CheckingAccount extends bankAccount {

 // Default Transaction Fee
 private static double FEE = 2.5;

 // default constructor
 public CheckingAccount() {
     super();
 }


//Intilazing checking account with a default fee

 public CheckingAccount(int bankAccountNumber, double fee) {
     super(bankAccountNumber);
     FEE = fee;
 }


 public void deposit(double amount) {

     // case handling
     if( amount > 0) {
         bankBalance += amount;
         System.out.printf("Amount %.2f deposited%n", amount);

         // Apply Transaction Fee
         bankBalance -= FEE;
         System.out.printf("Fee %.2f Applied%n", FEE);
         System.out.printf("Current bankBalance is: %.2f%n", bankBalance);

     } else {
         System.out.println("A negative amount cannot be deposited");
     }
 }


 public void withdraw(double amount) {

     // case handling
     if(amount > 0) {
         // checking enough balance
         if((amount+FEE) <= bankBalance) {

             System.out.printf("Amount of %.2f withdrawn from bankAccount%n", amount);
             bankBalance -= amount;
             bankBalance -= FEE;
             System.out.printf("Fee of %.2f applied%n", FEE);
             System.out.printf("Current bankBalance is: %.2f%n", bankBalance);
         }
     } else {
         System.out.println("Negative amount cannot be withdrawn!");
     }
 }
}
