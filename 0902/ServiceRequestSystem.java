import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
public class ServiceRequestSystem {
    
    static class ServiceRequest implements Comparable<ServiceRequest>{
        String id;
        int priority;
        String description;
        ServiceRequest(String id,int priority,String description){
            this.id = id;
            this.priority = priority;
            this.description = description;
        }
        public int compareTo(ServiceRequest other){
            return Integer.compare(other.priority,this.priority);
        }
        public String toString(){
            return "id:"+id+"priority: "+priority+"description: "+description;
        }
    }
    private Map<String,ServiceRequest>requestMap;
    private PriorityQueue<ServiceRequest>requestQueue;
    public ServiceRequestSystem(){
        requestMap = new HashMap<>();
        requestQueue = new PriorityQueue<>();
    }
    public void addRequest(String id, int priority,String description){
        if(requestMap.containsKey(id)){
            System.out.println("已存在");
            return;
        }
        ServiceRequest newRequest = new ServiceRequest(id, priority, description);
        requestMap.put(id,newRequest);
        requestQueue.offer(newRequest);
        System.out.println(newRequest);
    }
    public void find (String id){
        ServiceRequest req =requestMap.get(id);
        if(req !=null){
            System.out.println("找到:"+req);
            }
            else{
                System.out.println("找不到");
            }
    }
    public void processNext(){
        ServiceRequest nextReq = requestQueue.poll();
        if(nextReq !=null){
            requestMap.remove(nextReq.id);
            System.out.println("處理:"+nextReq);
        }else{
            System.out.println("false");
        }
    }
    public void cancelRequest(String id){
        ServiceRequest reqToCancel = requestMap.remove(id);
        if(reqToCancel != null){
            requestQueue.remove(reqToCancel);
            System.out.println(reqToCancel.id);
        }else{
            System.out.println("false");
        }
    }
    public void printstatus(){
        System.out.println("數量:"+requestMap.size());
    }
    public static void main(String[] args) {
        ServiceRequestSystem system = new ServiceRequestSystem();
        system.addRequest("001", 5, "a");
        system.addRequest("002", 3, "b");
        system.addRequest("003", 8, "c");
        system.addRequest("004", 4, "d");
        system.find("001");
        system.cancelRequest("003");
        system.processNext();
        system.printstatus();
              
    }
}
