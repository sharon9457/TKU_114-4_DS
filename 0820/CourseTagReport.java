import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CourseTagReport {
    public static void main(String[] args){
        List<String> order  = new ArrayList<>();
        Set<String> name = new HashSet<>();
        Map<String,Integer> time = new HashMap();

        String[] classes ={"經濟學","管理學","程式設計","統計學"};
        for(int x =0;x<classes.length;x++){
            String count= classes[x];
            order.add(count);
            name.add(count); 
            time.put(count,time.getOrDefault(classes,0) +1);      

        System.out.println("順序"+order);
        System.out.println("次數"+time);
        System.out.println("科目"+classes);       

    }}}
    

