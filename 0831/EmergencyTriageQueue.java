import java.util.Comparator;
import java.util.PriorityQueue;
public class EmergencyTriageQueue {
    private final PriorityQueue<Patient>queue;
    private long counter =0;
    public record Patient(String id,int severity,long number) 
    {      
        public Patient{
            if(id == null ||id.isEmpty()){
                throw new IllegalArgumentException("flase");
            }
        }
    }
    public EmergencyTriageQueue(){
        Comparator<Patient>order =Comparator.comparingInt(Patient::severity).reversed().thenComparingLong(Patient::number).thenComparing(Patient::id);
        this.queue = new PriorityQueue<>(order);
    }
    public void register(String id , int severity){
        counter++;
        Patient patient = new Patient(id, severity, counter);
        queue.offer(patient);
        System.out.println("病歷號:"+id+"危急程度:"+severity+"到院順序"+counter);
    }
    public void peekNext(){
         Patient next = queue.peek();
    System.out.println("下一位病歷號:"+next.id()+"危急程度"+next.severity());
    }
    public void callNext(){
        Patient patient = queue.poll();
        System.out.println("病人:+"+patient.id()+"到診間");
        }
        public int getSize(){
            return queue.size();
        }
    
        public static void main(String[] args){
            EmergencyTriageQueue erqueue = new EmergencyTriageQueue();
            erqueue.register("001",2);
             erqueue.register("002",4);
              erqueue.register("003",2);
               erqueue.register("004",5);
               erqueue.callNext();
               erqueue.peekNext();
        }}
    
