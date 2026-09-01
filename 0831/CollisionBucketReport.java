import java.util.ArrayList;
import java.util.List;

public class CollisionBucketReport {
    private record Entry(int key,String value) {}
    private final List<List<Entry>>buckets;

    public CollisionBucketReport(int bucketCount){
        if(bucketCount <=0) throw new IllegalArgumentException("bucketCount");
        buckets = new ArrayList<>();
        for(int i = 0;i<bucketCount;i++)buckets.add(new ArrayList<>());
    }
    private int index(int key){
        return Math.floorMod(Integer.hashCode(key),buckets.size());        
    }
    public void put(int key,String value){
        List<Entry>chain = buckets.get(index(key));
        for(int i =0;i<chain.size();i++){
            if(chain.get(i).key()==key){
                chain.set(i,new Entry(key, value));
                return;
            }
        }
        chain.add(new Entry(key, value));
    }
    public String get(int key){
        for(Entry entry:buckets.get(index(key))){
            if(entry.key()==key)return entry.value();
        }
        return null;
    }
    public boolean remove(int key){
        return buckets.get(index(key)).removeIf(entry -> entry.key()==key);
    }
    public void printBuckets(){
        int total =0;
        int max= 0;
        for(int x =0;x<buckets.size();x++){
            List<Entry>chain = buckets.get(x);
            int chainSize = chain.size();
            if(chainSize<1){
                total +=(chainSize -1);
            }
            if(chainSize>max){
                max = chainSize;
            }
            List<Integer>keys = new ArrayList<>();
            for(Entry entry:chain){
                keys.add(entry.key());
            }
            System.out.println(x+"->"+buckets.get(x));
        }
    }
    public static void main(String[] args){
        CollisionBucketReport table = new CollisionBucketReport(5);
        table.put(12,"A");
        table.put(7,"B");
        table.put(22,"C");
        table.put(-3,"D");
        table.put(7,"B2");
        table.printBuckets();
        System.out.println("get7=" +table.get(7));
        System.out.println("remove12="+table.remove(12));
        System.out.println("missing="+table.get(99));
    }
}
