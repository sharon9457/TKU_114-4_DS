import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterestSetComparison {
    public static Set<String> union(Set<String> set1,Set<String> set2){
        Set<String>result = new HashSet<>(set1);
        result.addAll(set2);
        return result;
    }
    public static Set<String>intersection(Set<String>set1,Set<String> set2){
        Set<String> result = new HashSet<>(set1);
        result.retainAll(set2);
        return result;
    }
    public static Set<String>firstOnly(Set<String>set1,Set<String> set2){
        Set<String>result = new HashSet<>(set1);
        result.removeAll(set2);
        return result;
    }
    public static Set<String>secondOnly(Set<String>set1,Set<String>set2){
        Set<String>result = new HashSet<>(set2);
        result.removeAll(set1);
        return result;
    }        
    public static void main(String[] args) {
        Set<String> p1= Set.of("唱歌","跳舞","聽音樂","睡覺");
        Set<String> p2= Set.of("唱歌","做甜點","看書","睡覺");
        System.out.println("人員1興趣"+p1);
        System.out.println("人員2興趣"+p2);
        System.out.println("聯集"+union(p1, p2));
        System.out.println("交集"+intersection(p1, p2));
        System.out.println("First-only"+firstOnly(p1, p2));
        System.out.println("Second-only"+secondOnly(p1, p2));
    }
    
}
