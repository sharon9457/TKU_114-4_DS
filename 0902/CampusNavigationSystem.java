import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
public class CampusNavigationSystem {
    private Map<String,String>locations;
    private Map<String,List<String>>graph;

    public CampusNavigationSystem(){
        locations = new HashMap<>();
        graph = new HashMap<>();
    }
    public void addlocations(String id ,String name){
        locations.put(id,name);
        graph.putIfAbsent(id, new ArrayList<>());
    }
    public void addroad(String id1,String id2){
        if(graph.containsKey(id1) &&graph.containsKey(id2)){
            graph.get(id1).add(id2);
            graph.get(id2).add(id1);
        }
    }
    private String getLocationName(String id){
        return locations.getOrDefault(id, id);
    }
    public void navigate(String startId,String targetId){
        System.out.println(getLocationName(startId)+"->"+getLocationName(targetId));

        if(!graph.containsKey(startId)||!graph.containsKey(targetId)){
            System.out.println("false");
            return;
        }
        Queue<String>queue = new ArrayDeque<>();
        Set<String>visited = new HashSet<>();
        Map<String,String>previous = new HashMap<>();

        queue.offer(startId);
        visited.add(startId);

        while(!queue.isEmpty()){
            String current = queue.poll();
        
        if(current.equals(targetId))break;
        for(String neighbor:graph.getOrDefault(current, Collections.emptyList())){
            if(visited.add(neighbor)){
                previous.put(neighbor, current);
                queue.offer(neighbor);
            }
        }
    }
    if(!visited.contains(targetId)){
        System.out.println("false");
        return;
    }
    List<String>path = new ArrayList<>();
    for(String node = targetId;node != null;node = previous.get(node)){
        path.add(node);
    }
    Collections.reverse(path);
    print(path);
}
private void print(List<String> path){
    System.out.println("路線");
    for(int i =0;i<path.size();i++){
        String nodeid = path.get(i);
        System.out.println(getLocationName(nodeid));
        if(i<path.size()-1){
            System.out.println("->");
        }
    }
    System.out.println(path.size()-1);
}    
    public static void main(String[] args) {
        CampusNavigationSystem graph = new CampusNavigationSystem();
    
    graph.addlocations("a","工學院");
    graph.addlocations("b","宿舍");
    graph.addlocations("c","學餐");
    graph.addlocations("d","理學院");
    graph.addlocations("e","文學院");
    graph.addlocations("f","商管學院");

    graph.addroad("a","b");
     graph.addroad("a","c");
      graph.addroad("a","d");
       graph.addroad("e","f");
        graph.addroad("d","e");
         graph.addroad("a","f");

         graph.navigate("a","c");
         graph.navigate("a","f");
         graph.navigate("a","z");
         }}