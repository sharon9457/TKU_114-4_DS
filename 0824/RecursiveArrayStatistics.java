public class RecursiveArrayStatistics {
    

    public static int maximum(int[] arr){
        if(arr == null ||arr.length == 0){
            throw new IllegalArgumentException("false");
        }
        return maxhelper(arr,0);
    }
    public static int maxhelper(int[] arr,int index){
        if(index == arr.length-1){
            return arr[index];
        }
        return Math.max(arr[index],maxhelper(arr,index +1));
    }
    public static int minimum(int[] arr){
        if(arr == null ||arr.length == 0){
            throw new IllegalArgumentException("false");
        }
        return minhelper(arr,0);
    }
    public static int minhelper(int[] arr,int index){
        if(index == arr.length-1){
            return arr[index];
        }
        return Math.max(arr[index],minhelper(arr,index +1));
    }
    public static int count(int[] arr,int threshold){
        if(arr == null ||arr.length == 0){
            throw new IllegalArgumentException("false");
        }
        return counthelper(arr,threshold,0);
    }
    public static int counthelper(int[] arr,int index,int threshold){
        if(index == arr.length){
            return 0;
        }
        int current = (arr[index]>threshold)?1:0;
        return current+counthelper(arr,threshold,index +1);
    }
    public static void maint(String[] args){
        int[] data = {12,34,56,-23,45,13,18};
        System.out.println("max:"+maximum(data));
        System.out.println("min:"+maximum(data));
        System.out.println("大於30的數字:"+count(data, 30));
    }
    
}
