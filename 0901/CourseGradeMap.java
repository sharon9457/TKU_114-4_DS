import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.TreeMap;
public class CourseGradeMap {
    private Map<String,List<Integer>> gradesMap;

    public CourseGradeMap(){
        this.gradesMap = new HashMap<>();
    }
    public void addGrade(String id,int grade){
        gradesMap.computeIfAbsent(id,k->new ArrayList<>()).add(grade);
    }
    public double getAverage(String id){
        List<Integer> grades = gradesMap.get(id);
        if(grades == null || grades.isEmpty()) return 0.0;

        double sum =0;
        for(int grade :grades){
            sum += grade;
        }
        return sum/grades.size();
    }
    public int getHighest(String id){
        List<Integer>grades = gradesMap.get(id);
        if(grades == null || grades.isEmpty())return 0;
        return Collections.max(grades);
    }
    public List<String>sortedReport(){
        Map<String,List<Integer>>sortedMap = new TreeMap<>(gradesMap);
        List<String> report = new ArrayList<>();

        for(Map.Entry<String,List<Integer>> entry:sortedMap.entrySet()){
            String id = entry.getKey();
            List<Integer> grades = entry.getValue();
            double avg = getAverage(id);
            int highest = getHighest(id);
            report.add("課程編號:"+id+"成績"+grades+"平均"+avg+"最高分"+highest);
        }
        return report;
    }    
    public static void main(String[] args) {
        CourseGradeMap system = new CourseGradeMap();

        system.addGrade("001",90);
        system.addGrade("001",78);
     system.addGrade("001",100);

        system.addGrade("002",90);
        system.addGrade("002",100);
        system.addGrade("002",93);

        system.addGrade("003",90);
        system.addGrade("003",68);

        System.out.println("平均:"+system.getAverage("001"));
        System.out.println("最高分:"+system.getHighest("001"));
        List<String>report = system.sortedReport();
        for(String line: report){
            System.out.println(line);
        }
    }
}
