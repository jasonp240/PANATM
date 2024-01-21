public class TransactionHistory {
    private String[] historyA;
    private String[] historyS;
    private int sizeA;
    private int sizeS;

    public TransactionHistory() {
        sizeA = 0;
        sizeS = 0;
        historyA = new String[sizeA];
        historyS = new String[sizeS];
    }

    public void addHistory(String action) {
        sizeS++; // keeps track of the size of the list and also expands the list
        String[] temp = new String[sizeS]; // makes new temporary list
        for (int i = 0; i < temp.length; i++) {
            if (i < historyS.length) { // adds original things in the list to the temporary list
                temp[i] = historyS[i];
            } else { // else it puts the new information in the list
                if (action.equals("pin")) {
                    temp[i] = "Pin changed";
                }
                if (action.equals("get balance")) {
                    temp[i] = "Viewed Balance";
                }
                if (action.equals("get transaction")) {
                    temp[i] = "Viewed Transaction History";
                }
            }
        }
        historyS = temp;
    }

    public void addHistory(double amount, String type) { // method is similar to addHistory
        sizeA++;
        String[] temp = new String[sizeA];
        for (int i = 0; i < temp.length; i++) {
            if (i < historyA.length) {
                temp[i] = historyA[i];
            } else {
                if (type.equals("withdrawS")) {
                    temp[i] = "Withdrawal of " + amount + " from savings account";
                }
                if (type.equals("depositS")) {
                    temp[i] = "Deposit of " + amount + " into savings account";
                }
                if (type.equals("withdrawC")) {
                    temp[i] = "Withdrawal of " + amount + " from checking account";
                }
                if (type.equals("depositC")) {
                    temp[i] = "Deposit of " + amount + " into checking account";
                }
                if (type.equals("transferSC")) {
                    temp[i] = "Transfer of " + amount + " from savings to checking account";
                }
                if (type.equals("transferCS")) {
                    temp[i] = "Transfer of " + amount + " from checking to savings account";
                }
            }
        }
        historyA = temp;
    }

    public void printHistoryA() {
        if (sizeA == 0) {
            ConsoleUtility.clearScreen();
            System.out.println("No account Transactions have been logged!");
            ConsoleUtility.pause();
            ConsoleUtility.clearScreen();
        } else {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*          Transaction History          *");
            System.out.println("*          Account Transactions         *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            for (int i = 0; i < historyA.length; i++) { // basically makes sure the numbers are in the right form
                if (i < 10) {
                    System.out.println("A000" + (i + 1) + " - " + historyA[i]);
                } else if (i < 100) {
                    System.out.println("A00" + (i + 1) + " - " +  historyA[i]);
                } else if (i < 1000) {
                    System.out.println("A0" + (i + 1) + " - " + historyA[i]);
                } else {
                    System.out.println("A9999" + " - " + historyA[i]);
                }
            }
            ConsoleUtility.pause(historyA.length * 1000);
            ConsoleUtility.clearScreen();
        }
    }
    public void printHistoryS() {
        if (sizeS== 0) {
            ConsoleUtility.clearScreen();
            System.out.println("No security transactions have been logged!");
            ConsoleUtility.pause();
            ConsoleUtility.clearScreen();
        } else {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*          Transaction History          *");
            System.out.println("*         Security Transactions         *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            for (int i = 0; i < historyS.length; i++) {
                if (i < 10) {
                    System.out.println("S000" + (i + 1) + " - " + historyS[i]);
                } else if (i < 100) {
                    System.out.println("S00" + (i + 1) + " - " +  historyS[i]);
                } else if (i < 1000) {
                    System.out.println("S0" + (i + 1) + " - " + historyS[i]);
                } else {
                    System.out.println("S9999" + " - " + historyS[i]);
                }
            }
            ConsoleUtility.pause(historyA.length * 1000);
            ConsoleUtility.clearScreen();
        }
    }
}
