import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;
import java.util.LinkedList;
import java.util.List;

public class CollectionChoiceReport {
    public static void main(String[] args){
        List<String>search =new ArrayList<>();
        search.add("youtube");
        search.add("gmail");
        search.add("youtube");
        System.out.println(search);
        

        Set<String>id = new HashSet<>();
        id.add("001");
        id.add("002");
        boolean isadd = id.add("001");
        System.out.println(id);

        Map<String,Integer> map = new HashMap<>();
        map.put("101",88);
        map.put("102",77);
        Integer score = map.get("100");
        System.out.println(score);

        Queue<String>queue = new LinkedList<>();
        queue.offer("學測.pdf");
        queue.offer("報告.pdf");
        String job = queue.poll();
        System.out.println(job+","+queue);
        
        Deque<String> stack = new ArrayDeque<>();
        stack.push("輸入 'Hi");
        stack.push("刪除 'Hi");
        String last = stack.pop();   
        System.out.println(last+","+stack);
        }
    
}
