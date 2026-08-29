

public class RecursiveCallReport {
    public static int sum(int[] data,int index){
    String indent=" ".repeat(index);

    if(data.length ==0){
        System.out.println(indent+"enter sum");
        System.out.println(indent);
        return 0;
    }
    System.out.println(indent+"enter sum(index)"+index);
    int current = data[index];
    if(index == data.length -1){
        int recursive = 0;
        int value = current +recursive;
        System.out.println(indent+"Index"+index+"Current Value:"+current+"Recursive result:"+recursive+"Return Value"+value);

        return value;
    }
    int smallerresult = sum(data,index +1);
    int result = current + smallerresult;
    System.out.println(indent+"Index:"+index+"Current Value:"+current+
        "Recursive Result:"+result+"Return Value:"+result);
    return result;
    
}
public static void main(String[] args) {
    int[] normalArray={5,10,15};
    int[] singleArray = {42};
    int[] emptyArray = {};
    int answer1 = sum(normalArray,0);
    int answer2= sum(singleArray,0);
    int answer3 = sum(emptyArray,0);

    System.out.println(answer1+","+answer2+","+answer3);
    
}}
