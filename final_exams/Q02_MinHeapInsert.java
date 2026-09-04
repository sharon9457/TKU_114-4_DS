import java.util.ArrayList;
import java.util.List;


public class Q02_MinHeapInsert {
    private final List<Integer>heap = new ArrayList<>();

    public void add(int value){
        heap.add(value);
        up(heap.size()-1);
    }public void up(int index){
        while(index>0){
            int parentIndex = (index -1)/2;

            if(heap.get(index)>=heap.get(parentIndex)){
                break;
            }
            int temp = heap.get(index);
            heap.set(index,heap.get(parentIndex));
            heap.set(parentIndex,temp);

            index = parentIndex;

        }
    }

public Integer peek(){
    if(heap.isEmpty()){
        return null;
    }
    return heap.get(0);
}
public int size(){
    return heap.size();
}
public java.util.List<Integer> snapshot(){
    return new ArrayList<>(heap);
}
public boolean isValidMinHeap(){
    int n = heap.size();
    for(int i = 0;i<n;i++){
        int leftChild = 2*i+1;
        int rightChild = 2*i+2;
        if(leftChild<n&&heap.get(i)>heap.get(leftChild)){
            return false;
        }
        if(rightChild<n && heap.get(i)>heap.get(rightChild)){
            return false;
        }
    }
    return true;
}
public static void main(String[] args){
    Q02_MinHeapInsert min = new Q02_MinHeapInsert();
    System.out.println("Heap peek():"+min.peek());
    int[] value = {10,3,2,5,46,3};
    for(int val:value){
        min.add(val);
    }
    System.out.println(min.snapshot());
    System.out.println(min.peek());
    System.out.println(min.size());
    System.out.println(min.isValidMinHeap());
}
}
