import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class EnrollmentCleanup {
    public static void main(String[] args) {
        List<String>rawList = new ArrayList<>();
        rawList.add("Amy");
        rawList.add(" ");
        rawList.add("Sharon");
        rawList.add("Amy");
        rawList.add(null);
        rawList.add("Kyle");
        rawList.add("kai");

        System.out.println("原本的名單:");
        System.out.println(rawList);
        System.out.println("原始總數:"+rawList.size()+"\n");

        Iterator<String> iterator = rawList.iterator();
        while(iterator.hasNext()){
            String name =iterator.next();
            if(name == null ||name.trim().isEmpty()){
                iterator.remove();
            }
        }
        System.out.println(rawList);
        Set<String> uname = new HashSet<>();
        Set<String> dname = new HashSet<>();

        for(String name :rawList){
            boolean isnew = uname.add(name);
            if(!isnew){
                dname.add(name);                
            }
        }
        System.out.println("重複的名字:"+dname);        
    }
}
