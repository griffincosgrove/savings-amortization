/*
Coded by: Griffin Cosgrove
Date: February 1, 2019
Section 1 CIS 330
This program's purpose is to create an amortization schedule based on 
user input. Users will be able to visualize their loan and payments
 */
package HW4;
import java.util.*;
public class dukeAmortization {
    public static void main(String[] args) {
        int menuChoice;
        Scanner keyboardIn = new Scanner(System.in);
        System.out.println("Welcome to DukeAmort");
        System.out.println("Please Choose a menu option");
        do             
        //utilizing a do while loop to create the menu system
        {
            System.out.println("1: Savings Table");
            System.out.println("2: Loan Payoff Schedule");
            System.out.println("3: Exit Program");
            System.out.println("===================");
            System.out.print("Choice: ");
            menuChoice = keyboardIn.nextInt();
         
            switch (menuChoice)     
            //utilizing a switch statement to create the menu options
            {
                case 1:
                    //creates a savings table that visualizes how much interest
                    //will accrue given the user input
                    System.out.println("===============");
                    System.out.println("Savings Table:");
                    System.out.println("===============");
                    System.out.print("Enter Beginning Amount: ");
                    double startAmount = keyboardIn.nextDouble();
                    System.out.print("Enter Yearly Interest Rate(%): ");
                    double interestRate = keyboardIn.nextDouble();
                    double monthlyRate = (interestRate /100) / 12;
                    System.out.print("Enter Number of Years: ");
                    int loanYears = keyboardIn.nextInt();
                    System.out.println("Savings Amortization");
                    System.out.println("=========================");
                    System.out.print("Peroid\t\t");
                    System.out.print("Principal\t");
                    System.out.print("Interest\t");
                    System.out.println("Balance");
                    int loanMonths = loanYears * 12;
                    int monthNumber = 1;
                                        
                    while (monthNumber <= loanMonths)
                        // this loop displays a visual representation of how
                        //much interests accrues in a savings account
                    {
                        System.out.print("Month #" + monthNumber);
                        System.out.print("\t");
                        monthNumber++;
                        double accruedInterest = monthlyRate * startAmount;
                        //accruedInterest is the interest money accumulated
                        System.out.printf("$%-15.2f", startAmount);
                        //System.out.print("\t");
                        System.out.printf("$%-15.2f", accruedInterest);
                        //System.out.print("\t");
                        startAmount += accruedInterest;
                        System.out.printf("$%-15.2f", startAmount);
                        System.out.println();
                    }
                        System.out.println("=========================");
                        break;
                    
                case 2:
                    // case 2 is a visual representation of paying off a loan
                    //given the user input
                    System.out.println("===============");
                    System.out.println("Loan Payoff");
                    System.out.println("===============");
                    System.out.print("Enter Beginning Debt: ");
                    double debt = keyboardIn.nextDouble();
                    System.out.print("Enter Yearly Interest Rate(%): ");
                    double intRate = keyboardIn.nextDouble();
                    double monthlyIntRate = (intRate/100) / 12;
                    // convert the interest rate to monthly rate
                    System.out.print("Monthly Payment: ");
                    double payment = keyboardIn.nextDouble();
                    //payment is a monthly payment towards the debt
                    int monthCounter = 1;
                    double intPayment = (monthlyIntRate * debt);
                    //intPayment represents the amount of interest on each
                    //payment
                    
                    if (intPayment > payment)
                    //this checks to make sure the debt can be paid off with 
                    // the payment amount
                    {
                        System.out.println("=========================");
                        System.out.println("**Your payment is smaller than your "
                                + "monthly interest**");
                        System.out.println("This means you will never pay off "
                                + "your debt!");
                        System.out.printf("Please try an amount larger than "
                                + "$%.2f%n", intPayment);
                        System.out.println("=========================");
                        break;
                    }
                    else 
                    //if the debt can be paid off this loop provides a 
                    //visualization of the time it will take to pay off the 
                    //debt with the desired payment.
                    {
                            System.out.println("Payoff Schedule:");
                            System.out.println("=========================");
                            System.out.print("Peroid\t\t");
                            System.out.print("Balance\t");
                            System.out.print("\tInterest\t");
                            System.out.print("Payment\t\t");
                            System.out.println("Balance");
                            Double subtractDebt = payment - intPayment;
                            while (debt > 0 && (debt - subtractDebt) > 0)
                            {
                            System.out.print("Month #" + monthCounter);
                            System.out.print("\t");
                            monthCounter++;
                            System.out.printf("$%-15.2f", debt);
                            System.out.printf("$%-15.2f", intPayment);
                            System.out.printf("$%-15.2f", payment);
                            subtractDebt = payment - intPayment;
                            debt -= subtractDebt;
                            System.out.printf("$%-15.2f", debt);
                            intPayment = (monthlyIntRate * debt);
                            System.out.println();
                            }
                            System.out.print("Month #" + monthCounter);
                            System.out.print("\t");
                            monthCounter++;
                            System.out.printf("$%-15.2f", debt);
                            System.out.printf("$%-15.2f", intPayment);
                            payment = debt + intPayment;
                            System.out.printf("$%-15.2f", payment);
                            debt = 0;
                            System.out.printf("$%-15.2f", debt);
                            System.out.println();
                            System.out.println("=========================");
                            break;    
                    }
                case 3:
                    // this option is used to exit the program
                    System.out.println("=========================");
                    System.out.println("Thank you!");
                    System.out.println("Exiting Program");
                    System.out.println("=========================");
                    break;
                
                default:
                    // the default case is used to handle exceptions.
                    System.out.println("=========================");
                    System.out.println("Please enter 1, 2, or 3");
                    System.out.println("=========================");
            }    
        } while (menuChoice != 3);
        
    }
    
}
