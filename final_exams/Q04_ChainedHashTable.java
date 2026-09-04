import java.util.ArrayList;
import java.util.List;

public class Q04_ChainedHashTable {
    private final List<Entry>[]buckets;
        private final int count;
        private int size;
    private static class Entry{
        int key;
        String value;
        
        Entry(int key,String value){
            this.key = key;
            this.value = value;
        }      
    }
    public Q04_ChainedHashTable(int count){
        if(count <=0){
            throw new IllegalArgumentException("flase");
        }
        this.count = count;
        this.buckets = new ArrayList[count];
        for(int x =0;x<count;x++){
            this.buckets[x]=new ArrayList<>();
        }
        this.size=0;
    }
    private int getIndex(int key){
        int index = key % count;
        if(index <0){
            index += count;
        }
        return index;
    }
public void put(int key, String value){
    int index = getIndex(key);
    List<Entry>bucket = buckets[index];

    for(Entry entry:bucket){
        if(entry.key == key){
            entry.value = value;
            return;
        }
    }
    bucket.add(new Entry(key, value));
    size++;
}
public String get(int key){
    int index = getIndex(key);
    List<Entry>bucket = buckets[index];

    for(Entry entry:bucket){
        if(entry.key == key){
            return entry.value;
        }
    }
    return null;
}
public boolean remove(int key){
    int index = getIndex(key);
    List<Entry>bucket = buckets[index];

   
        for(int x =0;x<bucket.size();x++){
            if(bucket.get(x).key == key){
                bucket.remove(x);
                size--;
                return true;
            }
        }
        return false;
    }
    

public int size(){
    return size;
}

public int longestChain(){
    int max =0;
    for(List<Entry>bucket:buckets){
        if(bucket.size()>max){
            max = bucket.size();
        }
    }
    return max;
}
public static void main(String[]args){
    Q04_ChainedHashTable table= new Q04_ChainedHashTable(5);
    table.put(-1,"Tree");
    table.put(1,"two");
    table.put(4,"one");
    table.put(2,"updated");

    System.out.println(table.size());
    System.out.println(table.get(-3));
    System.out.println(table.get(2));
    }
}