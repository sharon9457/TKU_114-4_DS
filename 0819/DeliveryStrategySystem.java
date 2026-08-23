interface DeliveryMethod{
    double ship(double orderamount);
    String getsay();
}
class Home implements DeliveryMethod{
    public double ship(double orderAmount){
        if(orderAmount>=1500){
            return 0;
        }else
            return 300;
    }
    public String getsay(){
        return"要8天才送達";
    }
}
class prickup implements DeliveryMethod{
    public double ship(double orderAmount){
        if(orderAmount>=2000){
            return 0;
        }else
            return 100;
    }
    public String getsay(){
        return"要10天才送達";
    }
}
class own implements DeliveryMethod{
    public double ship(double orderAmount){
        if(orderAmount>=3000){
            return 0;
        }else
            return 500;
    }
    public String getsay(){
        return"要2天才送達";
    }
}
class OrderService{
    private String orderid;
    private double totalamount;
    private DeliveryMethod deliveryMethod;

    public OrderService(String orderid,double totalamount){
        this.orderid = orderid;
        this.totalamount = totalamount;
        }
        public void salemethod(DeliveryMethod deliveryMethod){
            this.deliveryMethod = deliveryMethod;
        }

public class DeliveryStrategySystem {
    public static void main(String[] args){
        OrderService myOrder1 = new OrderService("001",2000);
        OrderService myOrder2 = new OrderService("001",2000);
        OrderService myOrder3 = new OrderService("001",2000);

        System.out.println("超商取貨");
        myOrder1.salemethod(new prickup());

        System.out.println("宅配");
        myOrder1.salemethod(new Home());

        System.out.println("自取");
        myOrder1.salemethod(new own());  

    }
}
