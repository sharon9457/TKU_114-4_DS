class CourseGrade{
    private String studentid;
    private String studentname;
    private double attandscore;
    private double usualScore;
    private double midalscore;
    private double finalscore;

    public CourseGrade(String studentid,String studentname,double attandscore,double usualScore,double midalscore,double finalscore){
        this.studentid = studentid;
        this.studentname = studentname;
        this.attandscore = Math.max(0,Math.min(100,attandscore));
        this.usualScore = Math.max(0,Math.min(100,usualScore));
        this.midalscore =  Math.max(0,Math.min(100,midalscore));
        this.finalscore = Math.max(0,Math.min(100,finalscore));
    }
    public String getstudentid(){
        return studentid;
    }
    public String getstudentname(){
        return studentname;
    }
    public double totalscore(){
        return(usualScore*0.5)+(midalscore*0.2)+(finalscore*0.2)+(attandscore*0.1);
    }
    public String getLevel(){
        double x = totalscore();
       if(x>=90) return "A";
       if(x>=80) return "B";
       if(x>=70) return "C";
       if(x>=60) return "D";
       return "F";
    }
    public String toString(){
        return "學號:"+studentid+"姓名"+studentname+"總分:"+totalscore()+"等級:"+getLevel();
    }
}
public class CourseGradeManager {
    public static void main(String[] args) {
        CourseGrade[] grades ={
            new CourseGrade("4120001", "王老涅", 95,89, 100,100),
            new CourseGrade("4120002", "李大魁", 35,55, 44,33),
            new CourseGrade("4120003", "吳曉希", 60,60, 60,60),
            new CourseGrade("4120004", "京嘉明", 90,70, 80,80),
           new CourseGrade("4120005", "穆露露", 110,-10, 80,80)
        };
        double classcore=0;
        CourseGrade highestGrade=grades[0];
        for(int x = 0;x<grades.length;x++){
            double currentfinal = grades[x].totalscore();
          classcore +=currentfinal; 

           if(currentfinal >highestGrade.totalscore()){
            highestGrade = grades[x];
        }       
        }      

    double avrageScore =  classcore / grades.length;
    System.out.println("全班平均"+ avrageScore+ "分");
    System.out.println("最高分:"+highestGrade.getstudentname()+"分數:"+highestGrade.totalscore());
    for(int x =0;x<grades.length;x++){
         
        if(grades[x].getLevel().equals("F")){
           System.out.println("不及格的人:");
            System.out.println("姓名:"+grades[x].getstudentname()+"分數"+grades[x].totalscore());
        }
    }
    }
}
