import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BfsLayerReport {
    static Map<String,Integer> bfs(Map<String,List<String>>graph,String start){
        Map<String,Integer>distances= new LinkedHashMap<>();
        if(graph == null ||start == null||!graph.containsKey(start)){
            return distances;
        }
        Queue<String>queue = new ArrayDeque<>();
        Set<String>visited = new LinkedHashSet<>();
        queue.offer(start);
        visited.add(start);

        distances.put(start,0);
        while(!queue.isEmpty()){
            String current = queue.poll();
            int cuurentdistance = distances.get(current);

            for(String next:graph.getOrDefault(current,List.of())){
                if(graph.containsKey(next)&& visited.add(next)){
                    distances.put(next,cuurentdistance +1);
                    queue.offer(next);
        }
    }}
    return distances;
}
public static void main(String[] args){
    Map<String,List<String>>graph = new LinkedHashMap<>();
    graph.put("A",List.of("B","C"));
    graph.put("B",List.of("A","D"));
    graph.put("C",List.of("A","D"));
    graph.put("A",List.of("B","C"));
    graph.put("E",List.of());
    System.out.println(bfs(graph,"A"));
    System.out.println(bfs(graph,"E"));
    System.out.println(bfs(graph,"X"));
}
}