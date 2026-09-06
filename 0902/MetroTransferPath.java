import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
public class MetroTransferPath {
    static List<String> shortesdPath(Map<String,List<String>> graph,String start,String target){
        if(graph == null || !graph.containsKey(start) ||!graph.containsKey(target)){
            return List.of();

        }
        Queue<String>queue = new ArrayDeque<>();
        Set<String>visited = new HashSet<>();
        Map<String,String>previous = new HashMap<>();
        queue.offer(start);
        visited.add(start);
        while(!queue.isEmpty()){
            String current = queue.poll();
            if(current.equals(target))break;
            for(String next:graph.getOrDefault(current, List.of()))
                if(graph.containsKey(next)&& visited.add(next)){
                    previous.put(next,current);
                    queue.offer(next);
                }
        }
    }
    if(!visi)
}
