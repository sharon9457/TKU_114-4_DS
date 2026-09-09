import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
public class CoursePlanningGraph {
    private Map<String,List<String>>graph;
    public CoursePlanningGraph(){
        graph = new HashMap<>();
    }
    public void addCourse(String course){
        graph.putIfAbsent(course, new ArrayList<>());
    }
    public void add(String prerequisite,String course){
        addCourse(prerequisite);
        addCourse(course);

        graph.get(prerequisite).add(course);
    }
    public List<String> getcourses(String targetCourse){
        if(!graph.containsKey(targetCourse)){
            System.out.println("false");
            return Collections.emptyList();
        }
        List<String>affected = new ArrayList<>();
        Set<String>visited = new HashSet<>();
        visited.add(targetCourse);
        dfs(targetCourse,visited,affected);
        return affected;
    }
    private void dfs(String current,Set<String>visited,List<String>affected){
        for(String nextCourse:graph.getOrDefault(current, Collections.emptyList())){
            if(!visited.contains(nextCourse)){
                visited.add(nextCourse);
                affected.add(nextCourse);

                dfs(nextCourse, visited, affected);
            }
        }
        }
        public static void main(String[] args) {
            CoursePlanningGraph plan = new CoursePlanningGraph();
            plan.add("微積分", "離散數學");
             plan.add( "離散數學","線性代數");
              plan.add("資料結構", "程式設計");
               plan.add("程式設計", "作業系統");
               String target1 = "微積分";
               List<String>affected1 = plan.getcourses(target1);
               System.out.println(affected1);
        }
}
