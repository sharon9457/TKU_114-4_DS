import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CourseEnrollment {
    private final String studentId;
    private final String name;
    private int score;
    private final Set<String> tags = new HashSet<>();

    CourseEnrollment(String studentId, String name, int score) {
        this.studentId = studentId;
        this.name = name;
        this.score = Math.max(0, Math.min(100, score));
    }

    String getStudentId() {
        return studentId;
    }

    int getScore() {
        return score;
    }
    void setScore(int score){
        this.score = Math.max(0,Math.min(100,score));
    }

    void addTag(String tag) {
        if (tag != null && !tag.isBlank()) {
            tags.add(tag.toLowerCase());
        }
    }

    boolean hasTag(String tag) {
        return tag != null && tags.contains(tag.toLowerCase());
    }

    @Override
    public String toString() {
        return studentId + " " + name + " score=" + score + " tags=" + tags;
    }
}

class RegistrationBook {
    private final List<CourseEnrollment> order = new ArrayList<>();
    private final Set<String> registeredIds = new HashSet<>();
    private final Map<String, CourseEnrollment> byId = new HashMap<>();

    boolean enroll(CourseEnrollment enrollment) {
        if (enrollment == null
                || !registeredIds.add(enrollment.getStudentId())) {
            return false;
        }
        order.add(enrollment);
        byId.put(enrollment.getStudentId(), enrollment);
        return true;
    }

    CourseEnrollment find(String studentId) {
        return byId.get(studentId);
    }
    boolean Update(String studentId,int score){
        CourseEnrollment enrollment = find(studentId);
        if(enrollment != null){
            enrollment.setScore(score);
            return true;
        }
        return true;
    }
    List<CourseEnrollment>findByTag(String tag){
        List<CourseEnrollment> result = new ArrayList<>();
        for(CourseEnrollment e:order){
            if(e.hasTag(tag)){
                result.add(e);
            }
                }
                return result;
    }
    Map<String,Integer> scoreDistribution(){
        Map<String,Integer>score = new HashMap<>();
    score.put("A",0);
    score.put("B",0);
    score.put("C",0);
    score.put("D",0);

    for(CourseEnrollment e : order){
        int s = e.getScore();
        if(s >=90)score.put("A",score.get("A")+1);
        else if(s >=80)score.put("B",score.get("B")+1);
        else if(s >=90)score.put("C",score.get("C")+1);
        else if(s >=80)score.put("D",score.get("D")+1);
        else score.put("F",score.get("F")+1);
    }
    return score;   
    }
    
    List<CourseEnrollment> ranking() {
        List<CourseEnrollment> result = new ArrayList<>(order);
        result.sort(Comparator.comparingInt(CourseEnrollment::getScore)
                .reversed()
                .thenComparing(CourseEnrollment::getStudentId));
        return result;
    }
     List<CourseEnrollment> top (int count){
        List<CourseEnrollment> ranked = ranking();
        return ranked.subList(0,Math.min(count,ranked.size()));
     } 

    void removeBelow(int minimum) {
        order.removeIf(enrollment -> enrollment.getScore() < minimum);
        registeredIds.clear();
        byId.clear();
        for (CourseEnrollment enrollment : order) {
            registeredIds.add(enrollment.getStudentId());
            byId.put(enrollment.getStudentId(), enrollment);
        }
    }}
public class CourseCollectionManager {
    public static void main(String[] args) {
        RegistrationBook book = new RegistrationBook();

        CourseEnrollment e1 = new CourseEnrollment("S101", "Amy", 88);
        CourseEnrollment e2 = new CourseEnrollment("S102", "Ben", 55);
        CourseEnrollment e3 = new CourseEnrollment("S103", "Cara", 88);
        CourseEnrollment e4 = new CourseEnrollment("S104", "Bob", 66);
        CourseEnrollment e5 = new CourseEnrollment("S105", "Petter", 77);
        CourseEnrollment e6 = new CourseEnrollment("S106", "Ken", 95);

        e1.addTag("Java");
        e1.addTag("java");
        e3.addTag("   ");
        e4.addTag("Java");
        e5.addTag("java");

        book.enroll(e1);
        book.enroll(e2);
        book.enroll(e3);
        book.enroll(e4);
        book.enroll(e5);
        book.enroll(e6);   
         

    
        System.out.println("duplicate=" + book.enroll(
                new CourseEnrollment("S101", "Amy2", 100)));
        
        System.out.println("成績:");
        System.out.println(book.scoreDistribution());
    
        book.removeBelow(60);
        System.out.println("清理後人數:" + book.ranking().size());
    }
}

