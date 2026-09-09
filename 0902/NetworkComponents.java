import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
public class NetworkComponents {
    static void addEdge(Map<String,List<String>> graph,String x,String y){
        graph.putIfAbsent(x,new ArrayList<>());
        graph.putIfAbsent(y,new ArrayList<>());
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
    static List<List<String>>find(Map<String,List<String>> graph){
        List<List<String>>components = new ArrayList<>();
        Set<String>visited = new HashSet<>();

        for(String node:graph.keySet()){
            if(!visited.contains(node)){
                List<String>current = new ArrayList<>();
                dfs(graph,node,visited,current);

                components.add(current);
            }
        }
        return components;
    }
    static void dfs(Map<String,List<String>>graph,String current,Set<String>visited,List<String>component){
        visited.add(current);
        component.add(current);

        for(String neighbor:graph.getOrDefault(current, List.of())){
            if(!visited.contains(neighbor)){
                dfs(graph, neighbor, visited, component);
            }
        }
    }
public static void main(String[] args) {
    Map<String,List<String>>graph = new HashMap<>();
    
    addEdge(graph, "a", "b");
    addEdge(graph, "b", "c");
    addEdge(graph, "d", "e");
    graph.put("f",new ArrayList<>());

    List<List<String>>components = find(graph);
    System.out.println("數量:"+components.size());

    List<String>maxcomponent = new ArrayList<>();
    for(int i=0;i<components.size();i++){
        List<String>comp = components.get(i);
        System.out.println("區塊"+(i+1)+":"+comp);
        if(comp.size()>maxcomponent.size()){
            maxcomponent = comp;
        }
    }
        System.out.println("max component:"+maxcomponent);
        System.out.println(maxcomponent.size());
    }   

    }

