import java.util.Comparator;
import java.util.PriorityQueue;
public class EventSimulationQueue {
    private final PriorityQueue<Event>queue;
    private long counter = 0;
    public record Event(String id,long time,String type,long number){
        public Event{
            if(id ==null ||id.isEmpty()){
                throw new IllegalArgumentException("flase");
            }
        }    
}
public EventSimulationQueue(){
    Comparator<Event>order = Comparator.comparingLong(Event::time).thenComparingLong(Event::number);
    this.queue = new PriorityQueue<>(order);
}
public void schedule(String id,long time,String type){
    counter++;
    Event event = new Event(id, time, type, counter);
    queue.offer(event);
    System.out.println("id"+id+"時間"+time+"類型"+type+"順序"+counter);
}
public void cancel(String id){
    boolean isRemoved = queue.removeIf(event ->event.id().equals(id));
    if(isRemoved){
        System.out.println(id+"取消成功");
    
    }
}
public void runSimulation(){
    while(!queue.isEmpty()){
        Event event = queue.poll();
        System.out.println("執行時間"+event.time()+"id"+event.id()+"類型"+event.type());
    }
    }
    public static void main(String[] args) {
        EventSimulationQueue lator = new EventSimulationQueue();
        lator.schedule("001",100,"A事件");
        lator.schedule("002",50,"B事件");
        lator.schedule("003",200,"C事件");
        lator.schedule("004",100,"A事件");
        lator.schedule("005",300,"E事件");
        System.out.println("取消");
        lator.cancel("003");
        lator.runSimulation();
    }}
