import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class ListImplementationLab{
        static void trace(List<Integer> list){
        list.add(10);
        list.add(20);
        list.add(30);
        System.out.println("尾端新增"+list);

        list.add(1,15);
        System.out.println("index 1 插入:"+list);

        list.remove(2);
        System.out.println("index2刪除:" +list);

        list.set(1,25);
        System.out.println("index 1 修改:" + list);

        int search =30;
        System.out.println("搜尋"+search+"的 index:"+list.indexOf(search));

        int sum =0;
        for(Integer num : list){
            sum +=num;
        }
        System.out.println("總和:"+sum);
      
    }
    public static void main(String[] args){
        System.out.println("ArrayList");
        trace(new ArrayList<>());
        System.out.println("LinkedList");
        trace(new LinkedList<>());
    }
}
//ArrayList會預留空間
//LinkedList 因為會把每個元素包裝成Node ，所以會對記憶體造成較大的負擔