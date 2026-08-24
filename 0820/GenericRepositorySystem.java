import java.util.ArrayList;
import java.util.List;
class Product{
    private String name;

    public Product(String name){
        this.name = name;
    }
    public String toString(){
        return "商品:"+name;
    }
}
class Repository<T>{
    private List<T> items;
    public Repository(){
        this.items = new ArrayList<>();
    }
    public void add(T item){
         items.add(item);
    }
    public void get(int index){
        items.get(index);
    }
    public boolean remove(T item){
        return items.remove(item);
    }
    public int size(){
        return items.size();
    }
    public void displayAll(){
        for(T item:items){
            System.out.println(item);
        }
        }
    }
public class GenericRepositorySystem {
    public static void main(String[] args) {
        Repository<String> strings = new Repository<>();
        strings.add("獵人");
        strings .add("海賊王");
        System.out.println("標籤?:");
        strings.displayAll();
        
        System.out.println("移除獵人標籤:");
        strings.remove("獵人");
        strings.displayAll();


        Repository<Product>products = new Repository<>();
        Product p1 = new Product("掛軸");
        Product p2 = new Product("娃娃");
        Product p3 = new Product("立牌");

        products.add(p1);
        products.add(p2);
        products.add(p3);
        
        System.out.println("所有商品");
        products.displayAll();
        System.out.println("移除第一個商品:");

        products.remove(p1);
        products.displayAll(); 
       
    }   
 }

