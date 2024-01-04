import java.util.Scanner;

public class Customer {
    private int pin;
    private String name;
    private int zipcode;
    private Scanner scan;

    public Customer(int pin, String name, int zipcode) {
        this.pin = pin;
        this.name = name;
        this.zipcode = zipcode;
        scan = new Scanner(System.in);
    }

    public void changePin() {
        System.out.println("*---------------------------------------*");
        System.out.println("*                                       *");
        System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
        System.out.println("*                                       *");
        System.out.println("*---------------------------------------*");
        System.out.print("Do you remember your pin? (y/n):");
        String userInput = scan.nextLine();

        while(!userInput.equals("y") && !userInput.equals("n")) {
            ConsoleUtility.clearScreen();
            System.out.println("Invalid Input!");
            ConsoleUtility.pause();
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Do you remember your pin? (y/n):");
            userInput = scan.nextLine();
        }

        if (userInput.equals("y")) {
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.println("Enter your pin: "); // add an option to get out of this menu
            int userInput2 = 0;
            while (userInput2 != pin) {
                try {
                    userInput2 = scan.nextInt();
                    scan.nextLine();
                } catch(Exception e) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Not A Number!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.println("Enter your pin: ");
                    userInput2 = scan.nextInt();
                    scan.nextLine();
                }
                if (userInput2 != pin) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Wrong Pin!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter your pin: ");
                    userInput2 = scan.nextInt();
                    scan.nextLine();
                }
            }
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter new pin: ");
            boolean pinChanged = false;
            while (!pinChanged) {
                try {
                    int newPin = scan.nextInt(); // fixed the logic here with showing the menu
                    scan.nextLine();
                    pinChanged = true;
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println("Not a number!");
                    ConsoleUtility.pause();
                    ConsoleUtility.clearScreen();
                    System.out.println("*---------------------------------------*");
                    System.out.println("*                                       *");
                    System.out.println("*              \uD83D\uDD11 Pin Change \uD83D\uDD11             *");
                    System.out.println("*                                       *");
                    System.out.println("*---------------------------------------*");
                    System.out.print("Enter new pin: ");
                    int newPin = scan.nextInt();
                    scan.nextLine();
                }
            }
        }
    }
}
