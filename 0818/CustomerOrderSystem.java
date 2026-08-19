class Customer{
    private String customerid;
    private String customername;
    
    Customer(String customerid,String customername){
        this.customerid = customerid;
        this.customername = customername;
    }
    public String getcutomerid(){
        return customerid;
    }
    public String getcustomername(){
        return customername;
    }
    public String toString(){
        return "名字:"+customername+"ID:"+customerid;
    }
}
class OrderItem{
    private String itemid;
    private String itemname;
    private int price;
    private int mumber;

    OrderItem(String itemid,String itemname,int price,int mumber){
        this.itemid = itemid;
        this.itemname = itemname;
        this.price = price;
        this.mumber = mumber;
    }
    public String getitemid(){
        return itemid;
    }
    public String getitemname(){
        return itemname;
        }
    public int getprice(){
        return price;
        }
    public int gettotal(){
            return price *mumber;
        }
    public int getmumber(){
        return mumber;
    }
    public String toString(){
        return "商品名稱:"+itemname+"商品編號:"+itemid+"價錢:"+price+"數量:"+mumber+"總金額:"+gettotal();
    }
}
class CustomerOrder{
    private String orderid;
    private Customer customer;
    private OrderItem[] items;

    public CustomerOrder(String orderid,Customer customer,OrderItem[] items){
        this.orderid = orderid;
        this.customer =customer;
        this.items = items;
    }

    public int totalAmount(){
        int total =0;
        for(int x =0;x<items.length;x++){
            total +=items[x].gettotal();
        }return total;
    }
    public int gettotalmumber(){
        int total = 0;
        for(int x = 0;x<items.length;x++){
            total +=items[x].gettotal();
        }return total;
    }
    public void print(){
        System.out.println("訂單編號:"+orderid);
        System.out.println("顧客訊息"+ customer.toString());
        for(int x =0;x<items.length;x++){
            System.out.println(items[x].toString());
        }
        System.out.println("商品全部數量:"+gettotalmumber());
        System.out.println("訂單總金額"+totalAmount());
    }
    }
public class CustomerOrderSystem {
    public static void main(String[] args) {
        Customer customer = new Customer("001","老涅");

        OrderItem[] items = {
            new OrderItem("0001","娃娃", 500, 8),
            new OrderItem("0002","立牌", 400, 3),
            new OrderItem("0003","掛軸", 900, 1),
        };

        CustomerOrder order = new CustomerOrder("aa001",customer,items);

        order.print();
    }
}
