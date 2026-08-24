import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordIndexSystem {
    public static void main(String[] args) {
        
        String[] strings = {
            "Hello world!",
            "Hi world!"

        };
        Map<String, Integer>  count= new HashMap<>();
        Set<String> words = new HashSet<>();

        for(String s :strings){
            String clean = s.toLowerCase().replaceAll("[,.!]","");
            String[] wordses = clean.split("\\s+");
        
        for(String word: wordses){
            if(word.isEmpty()){
                continue;                
            }
            words.add(word);                
            count.put(word,count.getOrDefault(word,0)+1);
        }        
        }    
    System.out.println("沒重複的單字:"+ words);

    for(String word :words){
        int counting = count.get(word);
        if(counting>=2){
            System.out.println(word+"出現"+counting+"次");
        }
    }
}
}

