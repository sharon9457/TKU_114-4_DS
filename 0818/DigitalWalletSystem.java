class DigitalWallet{
    private String walletId;
    private String owner;
    private int balance;
    private int count;

   DigitalWallet(String walletId,String owner){
    this. walletId = walletId;
    this.owner = owner;
    this.balance = 0;
    this.count = 0;
    }
    public void deposit(int amount){
        if(amount >0){
            this.balance += amount;
            this.count++;
        }
    }
    public boolean pay(int amount){
        if(amount>0 && amount<=this.balance){
            this.balance -= amount;
            this.count++;
            return true;
        }
        return false;
    }

    public void refund(int amount){
        if(amount >0){
            this.balance +=amount;
            this.count++;
        }
    }
    public String toString(){
        return "帳號:"+walletId +","+owner+"餘額:"+balance+",交易次數"+count;
    }
}

public class DigitalWalletSystem {
    public static void main(String[] args){
        DigitalWallet wallet = new DigitalWallet("000001","王大明");
        System.out.println(wallet);

        wallet.deposit(1000);
        System.out.println("存1000後:"+wallet);

        wallet.pay(500);
        System.out.println("領500後的餘額:"+wallet);

        wallet.pay(4000);
        System.out.println("付了4000後"+wallet);

        wallet.deposit(-500);
        wallet.pay(-200);
        System.out.println(wallet);

        wallet.refund(150);
        System.out.println("退款150後:"+wallet);

    }
}
