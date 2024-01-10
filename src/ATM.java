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
        System.out.print("Enter your zipcode");
        int zipcode = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter a Pin");
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
            System.out.print("Enter your original pin: ");
            try {
                userInput = scan.nextInt();
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
                ConsoleUtility.clearScreen();
                System.out.println("*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*                   ATM                 *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.print("Enter amount to withdraw: ");

                try {
                    double withdrawAMT = scan.nextDouble();
                    if (withdrawAMT > ) {
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
            }
        }
    }
}
