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
                    temp[i + 1] = "Pin Changed";
                }
                if (action.equals("get balance")) {
                    temp[i + 1] = "Viewed Balance";
                }
                if (action.equals("get transaction")) {
                    temp[i + 1] = "Viewed Transaction History";
                }
            }
        }
    }

    public void addHistory(double amount, String type) {
        size++;
        String[] temp = new String[size];
        for (int i = 0; i < history.length; i++) {
            temp[i] = history[i];
            if (history.length - 1 == i) {
                if (type.equals("withdrawS")) {
                    temp[i + 1] = "Withdrawal of " + amount + "into savings account";
                }
                if (type.equals("depositS")) {
                    temp[i + 1] = "Deposit of " + amount + "into savings account";
                }
                if (type.equals("withdrawC")) {
                    temp[i + 1] = "Withdrawal of " + amount + "into checking account";
                }
                if (type.equals("depositC")) {
                    temp[i + 1] = "Deposit of " + amount + "into checking account";
                }
                if (type.equals("transferSC")) {
                    temp[i + 1] = "Transfer of " + amount + "from savings to checking account";
                }
                if (type.equals("transferCS")) {
                    temp[i + 1] = "Transfer of " + amount + "from checking to savings account";
                }
            }
        }
    }

    public void printHistory() {
    }
}
