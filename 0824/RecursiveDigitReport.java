

public class RecursiveDigitReport {
    
    public static int digitSum(int n){
        if(n<0) return digitSum(-n);
        if(n<10) return n;
        return (n%10)+digitSum(n/10);
    }
    public static int digitCount(int n){
        if(n<0) return digitCount(-n);
        if(n<10) return 1;
        return 1+ digitCount(n/10);
    }
    public static int countDigit(int n , int digit){
        if(n <0) return countDigit(-n,digit);

        if(n<10){
            return(n == digit)?1:0;
        }
        int current = ((n%10) == digit)?1:0;
        return current +countDigit(n/10,digit);
    }
    public static void main(String[] args) {
        int[] test = {50205,0,-731};
        for(int n :test){
            System.out.println("總和:"+digitSum(n));
            System.out.println("總位數:"+digitCount(n));
            System.out.println("5出現次數:"+countDigit(n,5));

        }
    }
}
