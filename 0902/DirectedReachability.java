import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


public class DirectedReachability {

    static boolean rechable(Map<String,List<String>>graph,String start,String target){
        if(graph == null ||start == null || target == null||!graph.containsKey(start) ||!graph.containsKey(target))return false;
        Queue<String>queue = new ArrayDeque<>();
        Set<String>visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.equals(target))return true;
            for(String next :graph.getOrDefault(current, List.of())){
                if(graph.containsKey(next)&&visited.add(next))queue.offer(next);
            }
        }
        return false;
    }
    static List<Boolean>reachableMultiple(Map<String,List<String>>graph,List<List<String>>queries){
        List<Boolean>results = new ArrayList<>();
        if(queries == null)return results;

        for(List<String> query:queries){
            if(query != null && query.size()>2){
                String start = query.get(0);
                String target = query.get(1);
                results.add(rechable(graph,start,target));
            }else{
                results.add(false);
            }
        }
        return results;
    }
    public static void main(String[] args){
        Map<String ,List<String>>graph = Map.of("A",List.of("B"),"B,",List.of("C"),"C",List.of(),"X",List.of());
        System.out.println(rechable(graph,"A","C"));
        System.out.println(rechable(graph,"C","A"));
        System.out.println(rechable(graph,"X","X"));
               
    }    
}
