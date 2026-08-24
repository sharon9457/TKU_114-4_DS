import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

class Enrollment{
    private String studentId;
    private String courseCode;
public Enrollment(String studentId,String courseCode){
    this.studentId = studentId;
    this.courseCode = courseCode;
}
public boolean equals(Object o){
    if(this ==o) return true;
    if(o == null ||getClass() != o.getClass())return false;

    Enrollment that = (Enrollment) o;
    return Objects.equals(studentId, that.studentId)&&
    Objects.equals(courseCode,that.courseCode);
    }

    public int hashCode(){
        return Objects.hash(studentId,courseCode);
    }
    public String toString(){
        return "學號"+studentId+"課程"+courseCode;
    }
}
public class EnrollmentSetSystem {
    public static void main(String[] args) {
        Set<Enrollment> enrollments = new HashSet<>();
        Enrollment e1 = new Enrollment("412223333","A003");
        boolean add1 = enrollments.add(e1);
        System.out.println("新增:"+e1+"結果為:" + add1);
    
    Enrollment e2 = new Enrollment("41222333","C002");
    boolean add2 = enrollments.add(e2);
    System.out.println("新增:"+e2+"結果為:" +add2);

    Enrollment e3 = new Enrollment("41222333","B001");
    boolean add3 = enrollments.add(e3);
    System.out.println("重複新增"+e3+"->結果:"+add3);

    System.out.println("總數:" +enrollments.size());
    System.out.println("目前內容:"+ enrollments);
    Enrollment target = new Enrollment("41222333","B001");

    boolean htarget = enrollments.contains(target);
    System.out.println("取消"+target+"結果為:"+htarget);
    boolean removeResult = enrollments.remove(target);
    System.out.println("取消"+target +"結果"+removeResult);
    System.out.println("更改後整數:"+enrollments.size());
    System.out.println("更改後內容:"+enrollments);
}
}