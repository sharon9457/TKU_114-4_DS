import java.util.ArrayList;


public class RecursiveTextTools {
    public static String reverse(String s){
        if(s == null ||s.isEmpty()){
            return s;
        }
        return reverse(s.substring(1))+s.charAt(0);
    }
    public static int countCharacter(String s,char target){
        if(s == null ||s.isEmpty()){
            return 0;
        }
        int current = (s.charAt(0)== target)?1:0;
        return current+countCharacter(s.substring(1), target);
    }
    public static boolean isPalindrom(String s){
        if(s == null)return false;
        return ishelper(s, 0, s.length()-1);
    }
    private static boolean ishelper(String s,int left,int right){
        if(left >= right){
            return true;
        }
        if(s.charAt(left) == ' '){
            return ishelper(s, left+1, right);
        }
        if(s.charAt(right) == ' '){
            return ishelper(s, left, right-1);

        }
        if(Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))){
            return false;
        }
        return ishelper(s, left+1, right-1);
    }
    public static void main(String[] args) {
        String[] text ={
            "Happy day",
            "",
            
        };
        for(String test:text){
            System.out.println(test+isPalindrom(test));
        }
        System.out.println("recursion"+reverse("apple"));
        System.out.println("eleven e的數量:"+countCharacter("eleven", 'e'));
        
    }

}
