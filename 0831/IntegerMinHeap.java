import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;;

public class IntegerMinHeap {
    private final List<Integer>data = new ArrayList<>();

    public void add(int value){
        data.add(value);
        int index = data.size()-1;
        System.out.println("append"+value +"->"+data);

        while(index>0){
            int parent = (index-1)/2;
            if(data.get(parent)<=data.get(index))break;
            swap(parent,index);
            System.out.println("swap"+parent+","+index+"->"+data);
            index = parent;
        }
    }
    public Integer peek(){
        if(isEmpty()){
            throw new NoSuchElementException("false");
        }        
    return data.get(0);
    }
    public Integer removeMin(){
        if(isEmpty()){
            throw new NoSuchElementException("false");
        }
        int min = data.get(0);
        int last = data.remove(data.size()-1);

        if(!isEmpty()){
            data.set(0,last);
            int index =0;
            while(true){
                int left = 2*index+1;
                int right = 2*index+2;
                int smallest = index;

                if(left<data.size()&&data.get(left)<data.get(smallest)){
                    smallest = left;
                }
                if(right<data.size()&&data.get(right)<data.get(smallest)){
                    smallest = right;
                }
                if(smallest == index){
                    break;
                }
                swap(index, smallest);
                System.out.println("swap down"+index+","+smallest+"->"+data);
                index = smallest;
;            }
        }
        return min;
    }
    public int size(){
        return data.size();
    }
    public boolean isEmpty(){
        return data.isEmpty();
    }
    public List<Integer>snapshot(){
        return List.copyOf(data);
    }
    private void swap(int first,int second){
        int temp= data.get(first);
        data.set(first,data.get(second));
        data.set(second,temp);
    }
    
    public static void main(String[] args){
        IntegerMinHeap heap = new IntegerMinHeap();
        for(int value:new int[]{30,10,20,50,40,15}){
            heap.add(value);
        }System.out.println("heap=" +heap.snapshot());
        System.out.println("min="+heap.peek());
        System.out.println("size = "+heap.size());
    }

}
