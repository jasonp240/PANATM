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
            System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
            System.out.print("Enter your original " + ConsoleUtility.CYAN + "pin" + ConsoleUtility.RESET + ": ");
            try {
                userInput = scan.nextInt();
                if (userInput != pin) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "Wrong Pin!" + ConsoleUtility.RESET);
                    scan.nextLine();
                    ConsoleUtility.pause();
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Not A Number!" + ConsoleUtility.RESET);
                ConsoleUtility.pause();
            }
        }
        scan.nextLine();
        ConsoleUtility.clearScreen();
        System.out.println(ConsoleUtility.GREEN + "Success! Correct Pin Entered!" + ConsoleUtility.RESET);
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        String userName = "";
        while (!userName.equals(name)) {
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
            System.out.print("Enter your " + ConsoleUtility.CYAN + "name" + ConsoleUtility.RESET + ": ");
            userName = scan.nextLine();
            if (!userName.toLowerCase().equals(name)) {
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Name does not match our records!" + ConsoleUtility.RESET);
                ConsoleUtility.pause(2000);
                ConsoleUtility.clearScreen();
            }
        }

        ConsoleUtility.clearScreen();
        System.out.println(ConsoleUtility.GREEN + "Success! Correct Name Entered!" + ConsoleUtility.RESET);
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        int userZipCode = -1;
        while (userZipCode != zipcode) {
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*     If you want to change your pin,   *");
            System.out.println("*          we are going to need         *");
            System.out.println("*           some info from you          *");
            System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
            System.out.print("Enter your " + ConsoleUtility.CYAN + "Zipcode" + ConsoleUtility.RESET + ": ");
            try {
                userZipCode = scan.nextInt();
                if (userZipCode != zipcode) {
                    ConsoleUtility.clearScreen();
                    System.out.println(ConsoleUtility.RED + "ZipCode does not match our records!" + ConsoleUtility.RESET);
                    scan.nextLine();
                    ConsoleUtility.pause(2000);
                }
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Not A Number!" + ConsoleUtility.RESET);
                ConsoleUtility.pause();
            }
        }

        ConsoleUtility.clearScreen();
        System.out.println(ConsoleUtility.GREEN + "Success! Correct ZipCode Entered!" + ConsoleUtility.RESET);
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();

        boolean pinChanged = false;
        while (!pinChanged) {
            ConsoleUtility.clearScreen();
            System.out.println(ConsoleUtility.BLUE + "*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*               Pin Change              *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*" + ConsoleUtility.RESET);
            System.out.print("Enter new " + ConsoleUtility.CYAN + "pin" + ConsoleUtility.RESET + ": ");
            try {
                pin = scan.nextInt();
                pinChanged = true;
                scan.nextLine();
            } catch (Exception e) {
                scan.nextLine();
                ConsoleUtility.clearScreen();
                System.out.println(ConsoleUtility.RED + "Not a number!" + ConsoleUtility.RESET);
                ConsoleUtility.pause();
            }
        }
        ConsoleUtility.clearScreen();
        System.out.println(ConsoleUtility.GREEN + "Success! Pin Changed to " + pin + ConsoleUtility.RESET);
        ConsoleUtility.pause(2000);
        ConsoleUtility.clearScreen();
    }

    public int getPin() {
        return pin;
    }
}
