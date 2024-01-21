import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
public class ATM {
    private Customer customer;
    private Account savings;
    private Account checking;
    private TransactionHistory transactionHistory;
    private Scanner scan;

    public ATM() {
        scan = new Scanner(System.in);
        transactionHistory = new TransactionHistory();
    }

    public void start() {
        System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
        System.out.println("*                                       *");
        System.out.println("*                   ATM                 *");
        System.out.println("*                                       *");
        System.out.println("*          Welcome to the ATM!          *");
        System.out.println("*                                       *");
        System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
        System.out.print("Enter your " + ConsoleUtility.CYAN + "name" + ConsoleUtility.RESET + ": ");
        String name = scan.nextLine();
        System.out.print("Enter your " + ConsoleUtility.CYAN + "zipcode" + ConsoleUtility.RESET + ": ");
        int zipcode = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a " + ConsoleUtility.CYAN + "pin" + ConsoleUtility.RESET + ": ");
        int pin = scan.nextInt();
        scan.nextLine();

        customer = new Customer(pin, name.toLowerCase(), zipcode);
        savings = new Account(customer);
        checking = new Account(customer);

        int userInput = -1;
        boolean cont = false;
        int userPin = 0;
        while (userInput != 7) { // ends the loop if the user inputs 7
            while (!cont) { // keeps asking for pin to access the atm
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                System.out.print("Enter your " + ConsoleUtility.CYAN + "pin" + ConsoleUtility.RESET + " to continue: ");
                try {
                    userPin = scan.nextInt();
                    scan.nextLine();
                    if (userPin != customer.getPin()) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Wrong Pin!" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.GREEN + "Correct Pin!" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                        cont = true;
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Invalid Input (only #'s)" + ConsoleUtility.RESET);
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }
            cont = false;
            Boolean cont1 = false;
            while (!cont1) { // loop for main menu begins
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
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
                System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                System.out.print("Enter " + ConsoleUtility.CYAN + "action" + ConsoleUtility.RESET + "(1-7): ");
                try {
                    userInput = scan.nextInt();
                    scan.nextLine();
                    if (userInput < 1 || userInput > 7) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input (only 1-7)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                    } else {
                        cont1 = true;
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Invalid Input (#'s)" + ConsoleUtility.RESET);
                    ConsoleUtility.pause();
                }
            }
            if (userInput == 1) {
                String account = "";
                boolean done = false;
                while (!account.equals("savings") && !account.equals("checking") || !done) {
                    if (savings.getBalance() == 0 && checking.getBalance() == 0) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Insufficient Funds!" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                        break;
                    }
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility. BLUE + "*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Withdraw              *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("*            Savings Account            *");
                    System.out.println("*            Checking Account           *");
                    System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                    System.out.print("Enter " + ConsoleUtility.CYAN + "Account" + ConsoleUtility.RESET + ": ");
                    account = scan.nextLine();
                    if (!account.equals("savings") && !account.equals("checking")) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input! (checking or savings)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                    }
                    if (account.equals("savings") && savings.getBalance() == 0) { // doesn't allow the code to continue if their accounts don't have money
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Insufficient Funds" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else if (account.equals("checking") && checking.getBalance() == 0) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Insufficient Funds" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else {
                        done = true;
                    }
                }
                if (done) {
                    if (account.equals("savings")) {
                        withdraw(savings);
                    } else {
                        withdraw(checking);
                    }
                }
            } else if (userInput == 2) {
                String account = "";
                while (!account.equals("savings") && !account.equals("checking")) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Deposit               *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("*            Savings Account            *");
                    System.out.println("*            Checking Account           *");
                    System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                    System.out.print("Enter " + ConsoleUtility.CYAN + "Account" + ConsoleUtility.RESET + ": ");
                    account = scan.nextLine();
                    if (!account.equals("savings") && !account.equals("checking")) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input! (checking or savings)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                }
                if (account.equals("savings")) {
                    deposit(savings);
                } else {
                    deposit(checking);
                }
            } else if (userInput == 3) {
                String account = "";
                while (!account.equals("savings") && !account.equals("checking")) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Transfer              *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("*            Savings Account            *");
                    System.out.println("*            Checking Account           *");
                    System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                    System.out.print("Enter " + ConsoleUtility.CYAN + "Account" + ConsoleUtility.RESET + " to transfer " + ConsoleUtility.RED + "FROM " + ConsoleUtility.RESET + ": ");
                    account = scan.nextLine();
                    if (!account.equals("savings") && !account.equals("checking")) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input! (checking or savings)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                }
                if (account.equals("savings")) {
                    transfer(savings);
                } else {
                    transfer(checking);
                }
            } else if (userInput == 4) {
                System.out.println(ConsoleUtility.PURPLE + "Savings Account: " + ConsoleUtility.RESET);
                System.out.println(ConsoleUtility.GREEN + "$" + ConsoleUtility.RESET + savings.getBalance());
                System.out.println(ConsoleUtility.YELLOW + "Checking Account: " + ConsoleUtility.RESET);
                System.out.println(ConsoleUtility.GREEN + "$" + ConsoleUtility.RESET + checking.getBalance());
                ConsoleUtility.pause(2000);
                transactionHistory.addHistory("get balance");
            } else if (userInput == 5) {
                transactionHistory.printHistoryA();
                transactionHistory.printHistoryS();
            }
            else if (userInput == 6) {
                customer.changePin();
                transactionHistory.addHistory("pin");
            }
            String userInput1 = "";
            while (!userInput1.equals("y") && !userInput1.equals("n")) {
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                System.out.print("do you want to " + ConsoleUtility.GREEN + "continue" + ConsoleUtility.RESET + "? (y/n): ");
                try {
                    userInput1 = scan.nextLine();
                    if (!userInput1.equals("y") && !userInput1.equals("n")) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input! (y or n)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else if (userInput1.equals("n")){
                        userInput = 7;
                    }
                } catch (Exception e) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Invalid Input!" + ConsoleUtility.RESET);
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }
        }
        System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
        System.out.println("*                                       *");
        System.out.println("*                   ATM                 *");
        System.out.println("*                                       *");
        System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
        System.out.println(ConsoleUtility.GREEN + "Thank you for being a customer!" + ConsoleUtility.RESET);
    }
    private void withdraw(Account account) {
        boolean transactionDone = false;
        while (!transactionDone) {
            boolean done1 = false;
            double withdrawAMT = -1;
            while (!done1) {
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                 Withdraw              *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.println("* We can only give out $20 and $5 bills *");
                System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                System.out.print("Enter amount to " + ConsoleUtility.CYAN + "withdraw" + ConsoleUtility.RESET + ": ");
                try {
                    withdrawAMT = scan.nextDouble();
                    scan.nextLine();
                    if (withdrawAMT <= account.getBalance() && withdrawAMT % 5 == 0 && withdrawAMT >= 5) { // makes sure the amount taken out is a multiple of 5
                        done1 = true;
                    } else {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Amount (Must be able to be withdrawn by $5 and $20 Bills)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Invalid Input! (Must be #'s)" + ConsoleUtility.RESET);
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }

            int twentyDollarBills = 0;
            int fiveDollarBills = 0;
            while (twentyDollarBills * 20 + fiveDollarBills * 5 != withdrawAMT) {
                boolean done = false;
                if (withdrawAMT >= 20) { // skips this question if the withdrawn amount is less than 20
                    while (!done) {
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.BLUE +"*---------------------------------------*");
                        System.out.println("*                                       *");
                        System.out.println("*                   ATM                 *");
                        System.out.println("*                 Withdraw              *");
                        System.out.println("*                                       *");
                        System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                        System.out.print("Enter amount of " + ConsoleUtility.CYAN + "$20 bills" + ConsoleUtility.RESET + ": ");
                        try {
                            twentyDollarBills = scan.nextInt();
                            scan.nextLine();
                            done = true;
                        } catch (Exception e) {
                            scan.nextLine();
                            ConsoleUtility.clearScreen();
                            System.out.println(ConsoleUtility.RED + "Invalid Input! (Must be #'s)" + ConsoleUtility.RESET);
                            ConsoleUtility.pause();
                            ConsoleUtility.clearScreen();
                        }
                    }
                }
                done = false;
                while (!done) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.BLUE +"*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Withdraw              *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
                    System.out.print("Enter amount of " + ConsoleUtility.CYAN + "$5 bills" + ConsoleUtility.RESET + ": ");
                    try {
                        fiveDollarBills = scan.nextInt();
                        scan.nextLine();
                        done = true;
                    } catch (Exception e) {
                        scan.nextLine();
                        ConsoleUtility.clearScreen();
                        System.out.println(ConsoleUtility.RED + "Invalid Input! (Must be #'s)" + ConsoleUtility.RESET);
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                }
                if (twentyDollarBills * 20 + fiveDollarBills * 5 != withdrawAMT) { // checks if the amount of bills equals to the withdrawn amount
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Invalid amount of $20 and $5 bills!" + ConsoleUtility.RESET);
                    ConsoleUtility.pause(3000);
                    ConsoleUtility.clearScreen();
                } else {
                    account.withdraw(withdrawAMT);
                    if (account == savings) {
                        transactionHistory.addHistory(withdrawAMT, "withdrawS");
                        System.out.println("Withdrew $" + withdrawAMT + " from savings account");
                        ConsoleUtility.pause(2000);
                    } else {
                        transactionHistory.addHistory(withdrawAMT, "withdrawC");
                        System.out.println("Withdrew $" + withdrawAMT + " from checking account");
                        ConsoleUtility.pause(2000);
                    }
                    transactionDone = true;
                }
            }
        }
    }

    private void deposit(Account account) {
        double depositAMT = 0;
        boolean done1 = false;
        while (!done1) {
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*                   ATM                 *");
            System.out.println("*                 Deposit               *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
            System.out.print("Enter amount to " + ConsoleUtility.CYAN + "deposit" + ConsoleUtility.RESET + ": ");
            try {
                depositAMT = scan.nextDouble();
                scan.nextLine();
                done1 = true;
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Invalid Input! (Must be #'s)" + ConsoleUtility.RESET);
                ConsoleUtility.pause();
                ConsoleUtility.clearScreen();
            }
        }
        account.deposit(depositAMT);
        if (account == savings) {
            transactionHistory.addHistory(depositAMT, "depositS");
            System.out.println("Deposited $" + depositAMT + " into savings account");
            ConsoleUtility.pause(2000);
        } else {
            transactionHistory.addHistory(depositAMT, "depositC");
            System.out.println("Deposited $" + depositAMT + " into checking account");
            ConsoleUtility.pause(2000);
        }
    }

    private void transfer(Account account) {
        double transferAMT = 0;
        boolean done = false;
        while (!done) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*                   ATM                 *");
            System.out.println("*                 Transfer              *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter the amount to " + ConsoleUtility.CYAN + "transfer" + ConsoleUtility.RESET + ": ");
            try {
                transferAMT = scan.nextDouble();
                scan.nextLine();
                if (transferAMT > account.getBalance()) { // checks if the account has enough money to be transferred
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Insufficient funds!" + ConsoleUtility.RESET);
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                } else {
                    done = true;
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Invalid Input! (Only #'s)" + ConsoleUtility.RESET);
                ConsoleUtility.pause();
                ConsoleUtility.clearScreen();
            }
        }
        if (account == savings) {
            checking.deposit(transferAMT);
            savings.withdraw(transferAMT);
            transactionHistory.addHistory(transferAMT, "transferSC");
            System.out.println("Transferred $" + transferAMT + " into checking account from savings account");
            ConsoleUtility.pause(3000);
        } else {
            savings.deposit(transferAMT);
            checking.withdraw(transferAMT);
            transactionHistory.addHistory(transferAMT, "transferCS");
            System.out.println("Transferred $" + transferAMT + " into savings account from checking account");
            ConsoleUtility.pause(3000);
        }
    }
}
