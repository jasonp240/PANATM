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
        int userInput = -1;
        while (userInput != pin) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter your original pin: ");
            try {
                userInput = scan.nextInt();
                if (userInput != pin) {
                    ConsoleUtility.clearScreen();
                    System.out.println("Wrong Pin!");
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
        scan.nextLine();
        ConsoleUtility.clearScreen();
        System.out.println("Success! Correct Pin Entered!");
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        String userName = "";
        while (!userName.equals(name)) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter your name: ");
            userName = scan.nextLine();
            if (!userName.equals(name)) {
                ConsoleUtility.clearScreen();
                System.out.println("Name does not match our records!");
                ConsoleUtility.pause(2000);
                ConsoleUtility.clearScreen();
            }
        }

        ConsoleUtility.clearScreen();
        System.out.println("Success! Correct Name Entered!");
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        int userZipCode = -1;
        while (userZipCode != zipcode) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter your Zipcode: ");
            try {
                userZipCode = scan.nextInt();
                if (userZipCode != zipcode) {
                    ConsoleUtility.clearScreen();
                    System.out.println("ZipCode does not match our records!");
                    scan.nextLine();
                    ConsoleUtility.pause(2000);
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println("Not A Number!");
                ConsoleUtility.pause();
            }
        }

        ConsoleUtility.clearScreen();
        System.out.println("Success! Correct ZipCode Entered!");
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        boolean pinChanged = false;
        while (!pinChanged) {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Enter new pin: ");
            try {
                pin = scan.nextInt();
                pinChanged = true;
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println("Not a number!");
                ConsoleUtility.pause();
            }
        }
        ConsoleUtility.clearScreen();
        System.out.println("Success! Pin Changed to " + pin);
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();
    }

    public int getPin() {
        return pin;
    }
}
