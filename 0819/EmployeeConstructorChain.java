abstract class EmployeeBase{
    protected String id;
    protected String name;

    EmployeeBase(String id ,String name){
        this.id =id;
        this.name = name;
}
public abstract double pay();
}
class FullTimeEmployee extends EmployeeBase{
    private double monthlySalary;
    public FullTimeEmployee(String id,String name,double monthlySalary){
        super(id,name);
        this.monthlySalary = monthlySalary;
        
    }
    public double pay(){
        if(monthlySalary<0){
            return 0;
            }else {
                return monthlySalary;
    }}
}
class PartTimeEmployee extends EmployeeBase{
    private double hour;
    private double hoursalary;

    public PartTimeEmployee(String id,String name,double hour,double hoursalary){
        super(id,name);
        this.hour = hour;
        this.hoursalary = hoursalary;              
    }
    public double pay(){
        double validHour = hour;
        double validSalary = hoursalary;
        if(validHour <0){
            validHour = 0;
        }
        if(validSalary<0){
           validSalary = 0;
        }
        return validHour * validSalary;
}}

public class EmployeeConstructorChain {
    public static void main(String[] args){
    System.out.println("全職員工");
    EmployeeBase fullTime = new FullTimeEmployee("001","吳阿崎",29000);
    System.out.println("薪水:"+fullTime.pay());

    EmployeeBase partTime = new PartTimeEmployee("002","王老涅",-110,30);
    System.out.println("薪水:"+partTime.pay());
}
}
