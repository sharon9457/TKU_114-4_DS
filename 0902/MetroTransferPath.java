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
    
    if(!visited.contains(target)){
        return List.of();
    }
    List<String>path = new ArrayList<>();
    for(String node = target;node != null;node = previous.get(node)){
        path.add(node);
    }
    Collections.reverse(path);
    return path;
}
public static void main(String[] args) {
    Map<String,List<String>>graph = new HashMap<>();
    graph.put("a",List.of("b","c"));
    graph.put("b",List.of("c","d"));
    graph.put("c",List.of("e","f"));

    graph.put("d",List.of());
    graph.put("e",List.of());
    graph.put("f",List.of());

    String start = "a";
    String target ="f";

    List<String> path = shortesdPath(graph, start, target);
    System.out.println(start+"->"+target);
    System.out.println("最短路徑:"+String.join("->",path));

    if(!path.isEmpty()){
        int count = path.size()-1;
        System.out.println("邊數:"+count);
    }
    else{
        System.out.println("false");
    }

    int edgcount = path.size()-1;
    System.out.println("邊數"+edgcount);
}
}

