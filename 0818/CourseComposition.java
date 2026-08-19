class Instructor{
    private String id;
    private String name;

    Instructor(String id,String name){
        this.id = id;
        this.name = name;
    }
    public String getid(){
        return id;
    }   
    public String getname(){
        return name;
    }
}
class Course{
    private String courseCode;
    private String title;
    private Instructor instructor;
     Course(String courseCode,String title,Instructor instructor){
        this.courseCode = courseCode;
        this.title = title;
        this.instructor = instructor;
    }
    public String summary(){
    return "課程代碼:"+ courseCode +"課程名稱:"+title+"教師:" + instructor.getname()+"教授"+ "教師編號:"+ instructor.getid();
}
}

public class CourseComposition {
    public static void main(String[] args){
        Instructor staff = new Instructor("B001","王大明");
        Course course1 = new Course("001","統計學",staff);
        Course course2 = new Course("002","管理學",staff);

        System.out.println(course1.summary());
        System.out.println(course2.summary());

    }    
}
