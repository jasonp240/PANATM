import java.util.Scanner;
public class ATM {
    private Customer customer;
    private Account savings;
    private Account checking;
    private TransactionHistory transactionHistory;
    private Scanner scan;
    public ATM(){
        scan = new Scanner(System.in);
        transactionHistory = new TransactionHistory();
    }

    public void start() {
        System.out.println("*---------------------------------------*");
        System.out.println("*                                       *");
        System.out.println("*                   ATM                 *");
        System.out.println("*                                       *");
        System.out.println("*          Welcome to the ATM!          *");
        System.out.println("*                                       *");
        System.out.println("*---------------------------------------*");
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        System.out.print("Enter your zipcode: ");
        int zipcode = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a Pin: ");
        int pin = scan.nextInt();
        scan.nextLine();

        customer = new Customer(pin, name, zipcode);
        savings = new Account(customer);
        checking = new Account(customer);

        int userInput = -1;
        while (userInput != 7) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*                   ATM                 *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.println("* 1. Withdraw Money                     *");
            System.out.println("* 2. Deposit Money                      *");
            System.out.println("* 3. Transfer Money Between Accounts    *");
            System.out.println("* 4. Get Account Balances               *");
            System.out.println("* 5. Get Transaction History            *");
            System.out.println("* 6. Change Pin                         *");
            System.out.println("* 7. Exit                               *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter action (1-7): ");
            try {
                userInput = scan.nextInt();
                scan.nextLine();
                if (userInput < 1 || userInput > 7) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Invalid Input!");
                    scan.nextLine();
                    ConsoleUtility.pause();
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println("Not A Number!");
                ConsoleUtility.pause();
            }
            if (userInput == 1) {
                String account = "";
                while (!account.equals("savings") && !account.equals("checking")) {
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("*            Savings Account            *");
                    System.out.println("*            Checking Account           *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter Account: ");
                    account = scan.nextLine();
                    if (!account.equals("savings") && !account.equals("checking")) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Invalid Input!");
                        scan.nextLine();
                        ConsoleUtility.pause();
                    }
                }

                boolean transactionDone = false;
                while (!transactionDone) {
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("* We can only give out $20 and $5 bills *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter amount to withdraw: ");

                    try {
                        double withdrawAMT = scan.nextDouble();
                        int twentyDollarBills = -1;
                        int fiveDollarBills = -1;
                        if (withdrawAMT >= 5 && withdrawAMT % 5 == 0) {
                            while (twentyDollarBills * 20 + fiveDollarBills * 5 != withdrawAMT) {
                                if (account.equals("savings") && withdrawAMT > savings.getBalance() && withdrawAMT >= 20) {
                                    boolean done = false;
                                    while (!done) {
                                        ConsoleUtility.clearScreen();
                                        System.out.println("*---------------------------------------*");
                                        System.out.println("*                                       *");
                                        System.out.println("*                   ATM                 *");
                                        System.out.println("*                                       *");
                                        System.out.println("*---------------------------------------*");
                                        System.out.print("Enter amount of $20 bill/s: ");
                                        try {
                                            twentyDollarBills = scan.nextInt();
                                            scan.nextLine();
                                            done = true;
                                        } catch (Exception e) {
                                            ConsoleUtility.clearScreen();
                                            System.out.println("Invalid Input!");
                                            ConsoleUtility.pause();
                                            ConsoleUtility.clearScreen();
                                        }
                                    }
                                    done = false;
                                    while (!done) {
                                        ConsoleUtility.clearScreen();
                                        System.out.println("*---------------------------------------*");
                                        System.out.println("*                                       *");
                                        System.out.println("*                   ATM                 *");
                                        System.out.println("*                                       *");
                                        System.out.println("*---------------------------------------*");
                                        System.out.print("Enter amount of 5 bill/s: ");
                                        try {
                                            fiveDollarBills = scan.nextInt();
                                            scan.nextLine();
                                            done = true;
                                        } catch (Exception e) {
                                            ConsoleUtility.clearScreen();
                                            System.out.println("Invalid Input!");
                                            ConsoleUtility.pause();
                                            ConsoleUtility.clearScreen();
                                        }
                                    }
                                    if (twentyDollarBills * 20 + fiveDollarBills * 5 != withdrawAMT) {
                                        ConsoleUtility.clearScreen();
                                        System.out.println("Invalid amount of $20 and $5 bills!");
                                        ConsoleUtility.pause(3000);
                                        ConsoleUtility.clearScreen();
                                    }
                                }
                            }
                        } else {
                            ConsoleUtility.clearScreen();
                            System.out.println("Invalid withdraw amount!");
                            ConsoleUtility.pause();
                            ConsoleUtility.clearScreen();
                        }
                    } catch (Exception e){
                        ConsoleUtility.clearScreen();
                        System.out.println("Invalid withdraw amount!");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                }
            } else if (userInput == 6) {
                customer.changePin();
            }
        }
    }
}
