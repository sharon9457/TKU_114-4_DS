final class WalletTransaction {
    private final int sequence;
    private final String type;
    private final int amount;
    private final int balanceAfter;

    WalletTransaction(int sequence, String type, int amount, int balanceAfter) {
        this.sequence = sequence;
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }
    public int getsequence(){
        return sequence;
    }
    public String gettype(){
        return type;
    }
    public int getamount(){
        return amount;
    }

    @Override
    public String toString() {
        return sequence + " " + type + " " + amount
                + " balance=" + balanceAfter;
    }
}

class DigitalWallet {
    private final String walletId;
    private final String owner;
    private int balance;
    private final WalletTransaction[] transactions;
    private int transactionCount;

    DigitalWallet(String walletId, String owner, int historyCapacity) {
        this.walletId = walletId == null || walletId.isBlank()
                ? "UNKNOWN" : walletId;
        this.owner = owner == null || owner.isBlank() ? "Unknown" : owner;
        this.balance = 0;
        this.transactions = new WalletTransaction[Math.max(1, historyCapacity)];
        this.transactionCount = 0;
    }

    boolean deposit(int amount) {
        if (amount <= 0 || transactionCount >= transactions.length) {
            return false;
        }
        balance += amount;
        record("DEPOSIT", amount);
        return true;
    }

    boolean pay(int amount) {
        if (amount <= 0 || amount > balance
                || transactionCount >= transactions.length) {
            return false;
        }
        balance -= amount;
        record("PAY", amount);
        return true;
    }

    boolean refund(int amount) {
        if (amount <= 0 || transactionCount >= transactions.length) {
            return false;
        }
        balance += amount;
        record("REFUND", amount);
        return true;
    }
    WalletTransaction findTransaction(int sequence){
        for(int i =0;i<transactionCount;i++){
            if(transactions[i].getsequence()== sequence){
                return transactions[i];
            }
        }
        return null;
    }
    int totalbytype(String type){
        int total = 0;
        for(int i =0;i<transactionCount;i++){
            if(transactions[i].gettype().equals(type)){
                total += transactions[i].getamount();
            }
        }
        return total;
    }
    boolean transferTo(DigitalWallet target,int amount){
        if(amount <=0 || amount>balance || target == null || target == this){
            return false;
        }
        if(this.transactionCount>=this.transactions.length|| target.transactionCount>=target.transactions.length){
            return false;
        }
        this.balance -= amount;
        this.record("OUT",amount);

        target.balance +=amount;
        target.record("IN", amount);
        return true;
    }

    private void record(String type, int amount) {
        transactions[transactionCount] = new WalletTransaction(
                transactionCount + 1, type, amount, balance);
        transactionCount++;
    }

    void printStatement() {
        System.out.println(walletId + " owner=" + owner
                + " balance=" + balance);
        for (int i = 0; i < transactionCount; i++) {
            System.out.println(transactions[i]);
        }
    }
}

public class WalletHistoryManager {
    public static void main(String[] args) {
        DigitalWallet wallet1 = new DigitalWallet("W001", "Amy", 5);
        DigitalWallet wallet2 = new DigitalWallet("W002", "Chita", 2);

        System.out.println("wallet1 訂金 1000" + wallet1.deposit(1000));
        System.out.println("付 250=" + wallet1.pay(250));

        System.out.println("轉1000" +wallet1.transferTo(wallet2,500));

        System.out.println("wallet2 訂金100" + wallet2.deposit(100));
        System.out.println("wallet2 訂金100" + wallet2.deposit(100));
        System.out.println("已滿"+wallet1.transferTo(wallet2,100));
        System.out.println("尋找wallet1第3筆交易:"+wallet1.findTransaction(3));
        System.out.println("尋找wallet1第9筆交易:"+wallet1.findTransaction(9));
        System.out.println("wallet1花的總金額:" + wallet1.totalbytype("PAY"));
       
        wallet1.printStatement();
        wallet2.printStatement();
    }
}
