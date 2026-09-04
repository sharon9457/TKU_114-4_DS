import java.util.ArrayList;
import java.util.List;
public class Q03_MinHeapRemove {
    private final List<Integer>heap;

    public Q03_MinHeapRemove(List<Integer>values){
        heap = new ArrayList<>();

        if(values != null){
            for(Integer val:values){
                if(val !=null){
                    heap.add(val);
                }
            }
        }
        for(int i = (heap.size()/2)-1;i>=0;i--){
         down(i);
        }
    }
    public Integer remove(){
        if(heap.isEmpty()){
            return null;
        }Integer min = heap.get(0);
        Integer last = heap.remove(heap.size()-1);

        if(!heap.isEmpty()){
            heap.set(0,last);
            down(0);
        }
        return min;
    }private void down(int index){
        int n = heap.size();

        while(2*index+1<n){
            int leftChild = 2 *index +1;
            int rightChild = 2*index+2;
            int smallest = leftChild;

            if(rightChild <n && heap.get(rightChild)<heap.get(leftChild)){
                smallest = rightChild;
            }
            if(heap.get(index)<=heap.get(smallest)){
                break;
            }
            int temp = heap.get(index);
            heap.set(index,heap.get(smallest));
            heap.set(smallest,temp);

            index =smallest;;
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
    public List<Integer>snapshot(){
        return new ArrayList<>(heap);
    }
    public static void main(String[] args){
        List<Integer>input = java.util.Arrays.asList(15,3,45,34,null,89);
        Q03_MinHeapRemove min = new Q03_MinHeapRemove(input);
        System.out.println(min.snapshot());
        System.out.println(min.peek());
        System.out.println(min.size());
        while ((min.size()>0)) {
            System.out.println(min.remove()+" ");            
        }
        System.out.println(min.remove());

    }
    
}