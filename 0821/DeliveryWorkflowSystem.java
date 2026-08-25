import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

class Delivery{
    private String id;
    private String place;
    public Delivery(String id ,String place){
        this.id = id;
        this.place = place;
         }
         public String getid(){
            return id;
        }public String getplace(){
            return place;
        }
        public String toString(){
            return "編號:"+id+"目的地"+place;
        }}

public class DeliveryWorkflowSystem {
    private Map<String,Delivery> map = new HashMap<>();
    private Deque<Delivery> queue = new ArrayDeque<>();
    private Deque<Delivery>stack = new ArrayDeque<>();

    public void add(String id ,String place){
        Delivery x = new Delivery(id, place);
        map.put(id,x);
        queue.offerLast(x);
        System.out.println("新增:"+x);
    }
    public void process(){
        Delivery x = queue.pollFirst();
        stack.push(x);
        System.out.println(x);
    }
    public void undo(){
        Delivery x = stack.pop();
        queue.offerFirst(x);
        System.out.println("Undo:"+x);
    }
    public void count(){
        System.out.println("總數:"+map.size());
        System.out.println("等待中:"+queue.size()+","+queue);
        System.out.println("已完成"+stack.size());
    }
    public static void main(String[] args){
        DeliveryWorkflowSystem s = new DeliveryWorkflowSystem();

        s.add("001","台北");
        s.add("002","台中");
        s.add("003","台南");
        s.add("004","台東");
        s.count();

        s.process();
        s.process();
        s.undo();
        s.count();
        
    }
    
}
