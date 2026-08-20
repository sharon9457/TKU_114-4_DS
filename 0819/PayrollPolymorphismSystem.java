abstract class Employee{
    protected String id;
    protected String name;
   
    public Employee(String id , String name){
        this.id = id;
        this.name = name;
    }
    public String getname(){
        return name;
    }
    public abstract double pay();
}
class monthemployee extends Employee{
    private double monthsalary;

    public monthemployee(String id,String name,double monthsalary){
        super(id,name);
        this.monthsalary = monthsalary;
    }
    public double pay(){
        return monthsalary;
    }
}
class houremployee extends Employee{
    private double hour;
    private double hoursalary;

    public houremployee(String id,String name,double hour,double hoursalary){
        super(id,name);
        this.hour = hour;
        this.hoursalary = hoursalary;
    }
    public double pay(){
        return hoursalary * hour;
    }
}
class salemployee extends Employee{
    private double basesalary;
    private double sale;
    private double rate;

    public salemployee(String id,String name,double basesalary,double sale,double rate){
        super(id,name);
        this.basesalary = basesalary;
        this.sale= sale;
        this.rate = rate;
    }
    public double pay(){
        return basesalary+(sale * rate);
    }
}

public class PayrollPolymorphismSystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[]{
            new monthemployee("001","王老涅",100000),
            new houremployee("002","王大崎", 200,130),
            new salemployee("003","李小諾",20000 ,30000,0.5),
            new salemployee("004","趙大魁",20000,70000,0.1)
        };
        double maxsalary =0;
        String topName = "";

        for(int x =0;x<employees.length;x++){
            double currentpay = employees[x].pay();
        
        System.out.println("員工:"+employees[x].getname()+"薪水:"+currentpay);
        if(currentpay > maxsalary){
            maxsalary = currentpay;
            topName = employees[x].getname();
            System.out.println("最高薪資:"+topName);
        }        
    }
}}
