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
        String userInput = "";
        while(!userInput.equals("y") && !userInput.equals("n")) {
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            System.out.print("Do you remember your pin? (y/n): ");
            userInput = scan.nextLine();
            if (!userInput.equals("y") && !userInput.equals("n")) {
                ConsoleUtility.clearScreen();
                System.out.println("Invalid Input!");
                ConsoleUtility.pause();
                ConsoleUtility.clearScreen();
            }
        }

        if (userInput.equals("y")) {
            int userInput2 = -1;
            int errorCounter = 0;
            while (userInput2 != pin && errorCounter < 3) {
                ConsoleUtility.clearScreen();
                System.out.println("*---------------------------------------*");
                System.out.println("*                                       *");
                System.out.println("*               Pin Change              *");
                System.out.println("*                                       *");
                System.out.println("*---------------------------------------*");
                System.out.print("Enter your pin: ");
                try {
                    userInput2 = scan.nextInt();
                    if (userInput2 != pin) {
                        ConsoleUtility.clearScreen();
                        System.out.println("Wrong Pin!");
                        scan.nextLine();
                        errorCounter++;
                        ConsoleUtility.pause();
                    }
                } catch (Exception e) {
                    scan.nextLine();
                    ConsoleUtility.clearScreen();
                    System.out.println("Not A Number!");
                    ConsoleUtility.pause();
                }
            }



            ConsoleUtility.clearScreen();
            System.out.println("Success! Correct Pin Entered!");
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
                    int newPin = scan.nextInt();
                    pin = newPin;
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

        if (userInput.equals("n")) {
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

            int userZipCode = -1;
            while (userZipCode != pin) {
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
                    if (userZipCode != pin) {
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
            System.out.println("Success!");
            ConsoleUtility.pause();
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
                    int newPin = scan.nextInt();
                    pin = newPin;
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
    }
}
