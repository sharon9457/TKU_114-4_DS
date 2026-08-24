import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class StoreProduct implements Comparable<StoreProduct>{
    private final String id;
    private final String name;
    private final int price;
    private final int stock;

    StoreProduct(String id,String name,int price,int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock =stock;
    }
    String getid(){
        return id;
    }
    String getname(){
        return name;
        }
    int getprice(){
        return price;
    }
    int getstock(){
        return stock;
    }
    public int compareTo(StoreProduct other){
        return id.compareTo(other.id);
    }
    public String toString(){
        return id+"號,商品名稱:"+name+",價格:"+price+",庫存:"+stock;
    }

}
public class ProductComparatorPractice {
    public static void main(String[] args){
        List<StoreProduct>products = new ArrayList<>();
        products.add(new StoreProduct("001", "掛軸", 900, 10));
        products.add(new StoreProduct("002", "娃娃", 500, 5));
        products.add(new StoreProduct("005", "立牌", 500, 15));
        products.add(new StoreProduct("004", "公仔", 2000, 20));
        products.add(new StoreProduct("003", "拍立得", 100, 5));
        System.out.println("原來順序:"+products);

       Comparator<StoreProduct> byScore1 =
                Comparator.comparingInt(StoreProduct::getprice)
                        .reversed()
                        .thenComparing(StoreProduct::getname);
        products.sort(byScore1);
        System.out.println("by price=" + products);

        Comparator<StoreProduct> byScore2 =
                Comparator.comparingInt(StoreProduct::getstock)
                        .thenComparing(StoreProduct::getid);
        products.sort(byScore2);
        System.out.println("by stock=" + products);
    }
}
   
