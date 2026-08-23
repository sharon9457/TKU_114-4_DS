public class GenericArrayTools {

 static <T> int countMatches(T[] data, T target){
    if(data == null || data.length == 0){
       return 0;
    }
    int count = 0;
    for(int x =0;x<data.length;x++){
        T current = data[x];
        if(current == null){
            if(target == null){
                 count++;
            }               
        }           
        else{
            if(current.equals(target)){
                count++;
            }
        }
        }
        return count;
     }

static <T> T last(T[] data){
    if(data == null || data.length == 0){
        return null;
    }
    return data[data.length-1];
}
static <T> void swap(T[] data, int first, int second){
    if(data.length ==0 ||data.length <0){
        return ;
    }
    T temp =data[first];
    data[first] = data[second];
    data[second] = temp;
}

public static void main(String[] args) {    
    Integer[] data = {1,3,5,7,9};
    System.out.print("原本的陣列:");
    for(int x =0;x<data.length;x++){
        System.out.print(data[x]);
    }  
    System.out.println();     
    System.out.println("最後的數字:"+last(data));
    swap(data,1,3);
    System.out.println("移動第二和第四個陣列後:");
     for(int x =0;x<data.length;x++){
        System.out.print(data[x]);
    }   System.out.println();    
        System.out.println("9出現"+countMatches(data,9)+"次");    
}
}
