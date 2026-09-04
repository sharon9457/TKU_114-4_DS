import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IterativeDfsTrace {
static List<String>recusive(Map<String,List<String>>graph,String start){
    List<String>result = new ArrayList<>();
    if(graph == null||start == null||!graph.containsKey(start))return result;
    visited(graph,start,new LinkedHashSet<>(),result);
    return result;
}
private static void visited(Map<String,List<String>>graph,String current,Set<String> visited,List<String>result){
    
    if(!visited.add(current))return;
    result.add(current);
    for(String next: graph.getOrDefault(current,List.of())){
        if(graph.containsKey(next)){
            visited(graph,next,visited,result);
    }
}  
 }
static List<String>interative(Map<String,List<String>>graph,String start){
    List<String>result = new ArrayList<>();
    if(graph == null ||start == null ||!graph.containsKey(start))return result;
    ArrayDeque<String>stack = new ArrayDeque<>();
    Set<String>visited = new LinkedHashSet<>();
    stack.push(start);
    printState("Push",start,stack,visited);

    while(!stack.isEmpty()){
        String current = stack.pop();
        printState("Pop",current,stack,visited);

        if(!visited.add(current)) continue;
        result.add(current);
        List<String>neighbors = graph.getOrDefault(current, List.of());

        for(int i = neighbors.size() -1;i>0;i--){
            String next = neighbors.get(i);
            if(graph.containsKey(next)&&!visited.contains(next)){
                stack.push(next);
                printState("Push",next,stack,visited);
            }
        }
    }
    return result;
}
private static void printState(String action ,String node,ArrayDeque<String>stack,Set<String>visited){

    System.out.println(action+","+node+"Stack"+stack+"Visited"+visited);
}
public static void main(String[] args){
    Map<String,List<String>>graph = new LinkedHashMap<>();
    graph.put("A",List.of("B","C"));
    graph.put("B",List.of("D"));
    graph.put("C",List.of("D"));
    graph.put("D",List.of("A"));
    System.out.println(recusive(graph, "A"));
    System.out.println(recusive(graph, "A"));
}
}
