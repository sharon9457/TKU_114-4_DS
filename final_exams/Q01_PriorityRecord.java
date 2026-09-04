import java.sql.JDBCType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
public class Q01_PriorityRecord {
    public record Job(String id,int priority,long sequence){}

    public static List<String> processQrder(List<Job> jobs){
        if(jobs == null ||jobs.isEmpty()){
            return new ArrayList<>();
        }
        Comparator<Job>comparator = Comparator.comparingInt(Job::priority).thenComparing(Job::sequence).thenComparing(Job::id);

        PriorityQueue<Job> pq = new PriorityQueue<>(comparator);
        for(Job job:jobs){
            if(job != null){
                pq.offer(job);
            }
        }
        List<String>result = new ArrayList<>();
        while(!pq.isEmpty()){
            result.add(pq.poll().id());
        }
        return result;
    }
public static void main(String[] args){
    List<Job>jobs = Arrays.asList(
        new Job("a",2,34),
         new Job("c",1,24),
          new Job("b",1,34),
           new Job("d",1,34)
    );
    System.out.println (processQrder(jobs));
}}