class Product{
    private String id;
    private String name;
    private int stock;

    Product(String id,String name,int stock){
        this.id = id;
        this.name = name;
        this.stock = Math.max(0,stock);
    }

    boolean sell(int quantity){
        if(quantity <= 0 || quantity > stock){
            return false;
        }
        stock -= quantity;
        return true;
    }
    void restock(int quantity){
        if(quantity >0){
            stock += quantity;
        }
    }
    int getStock(){
        return stock;
    }
    public String toString(){
        return id +" "+name +"stock="+stock;
    }
}
public class ProductEncapsulationDemo {
    public static void main(String[] args){
        Product product = new Product("P101","Keyboard",8);

        System.out.println("銷售3個:"+product.sell(3));
        System.out.println("銷售9個:"+(9));
        product.restock(4);

        System.out.println(product);
    }
}
