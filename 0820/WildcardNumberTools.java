import java.util.ArrayList;
import java.util.List;
public class WildcardNumberTools {
    static double average(List<? extends Number> values){
        if (values == null||values.isEmpty()){
            return 0.0;
        }
        double sum = 0.0;
        for(Number num:values){
            sum += num.doubleValue();
        }
        return sum / values.size();            
    }
         
static double maximum(List<? extends Number> values){
    if (values == null||values.isEmpty()){
            return 0.0;
        }
    double max = values.get(0).doubleValue();
    for(Number num:values){
        if(num.doubleValue()>max){
            max = num.doubleValue();
        }
        }  
        return max;
}
static void addRange(List<? super Integer> target, int start, int end){
    
    for(int i = start;i<=end;i++){
     target.add(i);  
        }}
public static void main(String[] args) {
    List<Integer>scores = new ArrayList<>(List.of(1,3,5,7,9));
    List<Double> doubles = new ArrayList<>(List.of(2.2,4.4,6.3,8.3,10.3));
    
    System.out.println("平均值:"+average(scores));
    System.out.println("平均值:"+average(doubles));
    System.out.println("最大值:"+maximum(doubles));
    System.out.println("最大值:"+maximum(doubles));
    addRange(scores,10,12);
   
    System.out.println(scores);
    System.out.println(doubles);
}
}
