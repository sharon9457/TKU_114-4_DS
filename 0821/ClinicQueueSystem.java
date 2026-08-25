import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class Patient{
    private String id;
    private String name;

public Patient(String id ,String name){
    this.id = id;
    this.name = name;
}
public String getid(){
    return id;
}
public String getname(){
    return name;
}
public String toString(){
    return "病號"+id+"病人姓名:"+name;
}
}
public class ClinicQueueSystem{

        static String serveNext(Deque<Patient>waiting){
        Patient customer = waiting.pollFirst();
        return customer == null ? "EMTY":customer.toString();
    }
    public static void main(String[] args){
        Deque<Patient> waiting = new ArrayDeque<>();

        waiting.offerLast(new Patient("01",  "Kai"));
        waiting.offerLast(new Patient("02", "Chita"));
        waiting.offerLast(new Patient("03", "Nokoli"));
        waiting.offerLast(new Patient("04", "Nyrfier"));

        System.out.println("下一位:"+waiting.peekFirst());
        System.out.println("服務:"+serveNext(waiting));
        System.out.println("下一位:"+serveNext(waiting));
        System.out.println("剩餘:"+waiting );

    }
}
