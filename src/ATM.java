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
        System.out.print("Enter a pin: ");
        int pin = scan.nextInt();
        scan.nextLine();

        customer = new Customer(pin, name, zipcode);
        savings = new Account(customer);
        checking = new Account(customer);

        int userInput = -1;
        boolean cont = false;
        int userPin = 0;
        while (userInput != 7) {
            while (!cont) {
                ConsoleUtility.clearScreen();
                System.out.println("*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.print("Enter your pin to continue: ");
                try {
                    userPin = scan.nextInt();
                    scan.nextLine();
                    if (userPin != customer.getPin()) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Wrong Pin!");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else {
                        ConsoleUtility.clearScreen();
                        System.out.println("Correct Pin!");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                        cont = true;
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println("Not A Number!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }
            cont = false;

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
                boolean done = false;
                while (!account.equals("savings") && !account.equals("checking") || !done) {
                    if (savings.getBalance() == 0 && checking.getBalance() == 0) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Can't withdraw!");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                        break;
                    }
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Withdraw              *");
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
                        ConsoleUtility.pause();
                    }
                    if (account.equals("savings") && savings.getBalance() == 0) {
                        System.out.println("Invalid");
                    } else if (account.equals("checking") && checking.getBalance() == 0) {
                        System.out.println("Invalid");
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
                        ConsoleUtility.pause();
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
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("*            Savings Account            *");
                    System.out.println("*            Checking Account           *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter Account to transfer FROM: ");
                    account = scan.nextLine();
                    if (!account.equals("savings") && !account.equals("checking")) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Invalid Input!");
                        ConsoleUtility.pause();
                    }
                }
                if (account.equals("savings")) {
                    transfer(savings);
                } else {
                    transfer(checking);
                }

            } else if (userInput == 4) {
                System.out.println("Savings Account: ");
                System.out.println("$" + savings.getBalance());
                System.out.println("Checking Account: ");
                System.out.println("$" + checking.getBalance());
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
                System.out.println("*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.print("do you want to continue? (y/n): ");
                try {
                    userInput1 = scan.nextLine();
                    if (!userInput1.equals("y") && !userInput1.equals("n")) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Invalid Input!");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    } else if (userInput1.equals("n")){
                        userInput = 7;
                    }
                } catch (Exception e) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Invalid Input!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }
        }
    }
    private void withdraw(Account account) {
        boolean transactionDone = false;
        while (!transactionDone) {
            boolean done1 = false;
            double withdrawAMT = -1;
            while (!done1) {
                ConsoleUtility.clearScreen();
                System.out.println("*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                 Withdraw              *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.println("* We can only give out $20 and $5 bills *");
                System.out.println("*---------------------------------------*");
                System.out.print("Enter amount to withdraw: ");
                try {
                    withdrawAMT = scan.nextDouble();
                    scan.nextLine();
                    if (withdrawAMT <= account.getBalance() && withdrawAMT % 5 == 0 && withdrawAMT >= 5) {
                        done1 = true;
                    } else {
                        ConsoleUtility.clearScreen();
                        System.out.println("invalid");
                        ConsoleUtility.pause();
                        ConsoleUtility.clearScreen();
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println("Invalid withdraw amount!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                }
            }

            int twentyDollarBills = 0;
            int fiveDollarBills = 0;
            while (twentyDollarBills * 20 + fiveDollarBills * 5 != withdrawAMT) {
                boolean done = false;
                if (withdrawAMT >= 20) {
                    while (!done) {
                        ConsoleUtility.clearScreen();
                        System.out.println("*---------------------------------------*");
                        System.out.println("*                                       *");
                        System.out.println("*                   ATM                 *");
                        System.out.println("*                 Withdraw              *");
                        System.out.println("*                                       *");
                        System.out.println("*---------------------------------------*");
                        System.out.print("Enter amount of $20 bill/s: ");
                        try {
                            twentyDollarBills = scan.nextInt();
                            scan.nextLine();
                            done = true;
                        } catch (Exception e) {
                            scan.nextLine();
                            ConsoleUtility.clearScreen();
                            System.out.println("Invalid Input!");
                            ConsoleUtility.pause();
                            ConsoleUtility.clearScreen();
                        }
                    }
                }
                done = false;
                while (!done) {
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*                   ATM                 *");
                    System.out.println("*                 Withdraw              *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter amount of 5 bill/s: ");
                    try {
                        fiveDollarBills = scan.nextInt();
                        scan.nextLine();
                        done = true;
                    } catch (Exception e) {
                        scan.nextLine();
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
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*                   ATM                 *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter amount to deposit: ");
            try {
                depositAMT = scan.nextDouble();
                scan.nextLine();
                done1 = true;
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println("Invalid Input!");
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
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter the amount to transfer: ");
            try {
                transferAMT = scan.nextDouble();
                scan.nextLine();
                if (transferAMT > account.getBalance()) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Insufficient funds!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                } else {
                    done = true;
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println("Invalid Input!");
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
