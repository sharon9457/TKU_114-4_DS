class Account{
    private String accountid;
    private int balance;

    public Account(String accountid , int balance){
        this.accountid = accountid;
        this.balance = Math.max(0,balance);
    }
    public String getaccountid(){
        return accountid;
    }
    public int getbalance(){
        return balance;
    }
    void reduce(int amount){
        this.balance -= amount;
    }
    void wallet(int amount){
        this.balance += amount;
    }
    public String toString(){
        return "帳戶" +accountid+",餘額"+balance;
    }
}
class TransferService{
    public static boolean transfer(Account source,Account target,int amount){
        if(source == null ||target == null){
            System.out.println("找不到該用戶");
            return false;
        }
        if(source == target){
            System.out.println("不可為同一個帳戶");
            return false;
        }

        if(amount <=0){
            System.out.println("必須大於0元");
            return false;
        }
        if(source.getbalance() < amount){
            System.out.println("餘額不足");
            return false;
        }
        source.reduce(amount);
        target.wallet(amount);
        System.out.println("從"+source.getaccountid()+"轉出"+amount+"到"+target.getaccountid());
        return true;
    }
}
public class AccountTransferService {
    public static void main(String[] args) {
        Account a1 = new Account("001",5000);
         Account a2 = new Account("002",2000);
         System.out.println("初始金額:");
         System.out.println(a1);
         System.out.println(a2);

         System.out.println("轉2000:");
         TransferService.transfer(a1, a2, 1500);        

         System.out.println("轉9000:");
         TransferService.transfer(a1, a2, 9000);     

         TransferService.transfer(a1, a1, 900);       

         TransferService.transfer(a1, null, 900);
         
    }    
}
