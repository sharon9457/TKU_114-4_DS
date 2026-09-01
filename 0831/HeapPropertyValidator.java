import java.util.Arrays;
import java.util.List;

public class HeapPropertyValidator {
    public static boolean isMinHep(List<Integer>heap){
        if(heap == null){
            return false;
        }
        if(heap.size() <=1){
            return true;
        }
        for(int i =1;i<heap.size();i++){
            int parent = (i-1)/2;
             if(heap.get(i)<heap.get(getParentIndex(i))){
            return false;
        }
        }       
       return true;
}
public static boolean isMaxHep(List<Integer>heap){
    if(heap == null){
        return false;
    }
    if(heap.size()<=1){
        return true;
    }
    for(int x =1;x<heap.size();x++){
        int parentIndex = (x-1)/2;
        if(heap.get(x)>heap.get(parentIndex)){
        return false;
    }
    }    
return true;
}
public static int getParentIndex(int i){
    return(i-1)/2;
}
public static int leftIndex(int i){
    return 2*i+1;
} 
public static int rightIndex(int i){
    return 2*i+2;
}
public static String valueAt(List<Integer>heap,int index){
    if(index<0 || index >= heap.size()){
        return "null";
    }
    return String.valueOf(heap.get(index));
}
public static void main(String[] args){
    List<Integer> heap = List.of(10,20,30,40,50,60);
    for(int i =0;i<heap.size();i++){
        int parent = getParentIndex(i);
        int left = leftIndex(i);
        int right = rightIndex(i);
        System.out.printf("index=%d value=%d parent=%s left=%s right=%s%n",i,heap.get(i),valueAt(heap,parent),valueAt(heap,left),valueAt(heap,right));
    }}}
