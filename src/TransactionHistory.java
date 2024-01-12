public class TransactionHistory {
    private String[] history;
    private int size;

    public TransactionHistory() {
        size = 0;
        history = new String[size];
    }

    public void addHistory(String action) {
        size++;
        String[] temp = new String[size];
        for (int i = 0; i < history.length; i++) {
            temp[i] = history[i];
            if (history.length - 1 == i) {
                if (action.equals("pin")) {
                    temp[i] = "Pin Changed";
                }
                if (action.equals("get balance")) {
                    temp[i] = "Viewed Balance";
                }
                if (action.equals("get transaction")) {
                    temp[i] = "Viewed Transaction History";
                }
            }
        }
    }

    public void addHistory(double amount, String type) {
        size++;
        String[] temp = new String[size];
        for (int i = 0; i < temp.length; i++) {
            if (i < history.length) {
                temp[i] = history[i];
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
        history = temp;
    }

    public void printHistory() {
        if (size == 0) {
            ConsoleUtility.clearScreen();
            System.out.println("No actions have been logged!");
            ConsoleUtility.pause();
            ConsoleUtility.clearScreen();
        } else {
            ConsoleUtility.clearScreen();
            System.out.println("*---------------------------------------*");
            System.out.println("*                                       *");
            System.out.println("*          Transaction History          *");
            System.out.println("*                                       *");
            System.out.println("*---------------------------------------*");
            for (int i = 0; i < history.length; i++) {
                if (i < 10) {
                    System.out.println("000" + (i + 1) + " - " + history[i]);
                } else if (i < 100) {
                    System.out.println("00" + (i + 1) + " - " +  history[i]);
                } else if (i < 1000) {
                    System.out.println("0" + (i + 1) + " - " + history[i]);
                } else {
                    System.out.println("9999" + " - " + history[i]);
                }
            }
            ConsoleUtility.pause(history.length * 1000);
            ConsoleUtility.clearScreen();
        }
    }
}
