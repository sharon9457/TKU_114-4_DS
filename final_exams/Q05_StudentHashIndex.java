import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Q05_StudentHashIndex {
    private final Map<String ,Set<String>>studentcourse = new HashMap<>();
    private final Map<String,Set<String>>coursestudent = new HashMap<>();
    private int total =0;

    private String format(String input){
        if(input == null || input.trim().isEmpty()){
            return null;
        }
       String trummed = input.trim();
       return trummed.toUpperCase();
    }
    public boolean enroll(String studentId, String courseId){
        String sid = format(studentId);
        String cid = format(courseId);
        if(sid == null ||cid == null)return false;
       studentcourse.putIfAbsent(sid, new HashSet<>());
       Set<String>courses = studentcourse.get(sid);

       if(courses.contains(cid)){
        return false;
       }
       courses.add(cid);

       studentcourse.put(cid,new HashSet<>());
       Set<String>courese = studentcourse.get(cid);
       total++;
       return true;
    }
public boolean drop(String studentId, String courseId){
    String sid = format(studentId);
    String cid = format(courseId);
    Set<String> course = studentcourse.get(sid);
    if(course == null ||!course.remove(cid)){
        return false;
    }
    if(course.isEmpty()){
        studentcourse.remove(sid);
    }
    return true;
}
   public Set<String>courseOf(String studentId){
        String sid = format(studentId);
        if(sid == null || !studentcourse.containsKey(sid)){
            return Collections.emptySet();
        }
        return Collections.unmodifiableSet(new HashSet<>(studentcourse.get(sid)));
    }
       
public Set<String> studentsIn(String courseId){
    String cid = format(courseId);
    if(cid == null || !coursestudent.containsKey(cid)){
        return Collections.emptySet();
    }
           return Collections.unmodifiableSet(new HashSet<>(coursestudent.get(cid)));
    }
    public int enrollmentCount(){
        return total;
    }
    public static void main(String[]args){
        Q05_StudentHashIndex index = new Q05_StudentHashIndex();
        System.out.println(index.enroll("s1", "c1"));
        System.out.println(index.enroll("S1","C2"));
        var course = index.courseOf("s1");
            System.out.print(index.enrollmentCount());
            }
}