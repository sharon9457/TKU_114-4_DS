class Result<T>{
      private T value;

      void set(T value){
        this.value = value;
      }
      T get(){
        return value;
      }
      boolean isEmpty(){
        return value == null;
      }    
}
public class GenericResultDemo {
    public static void main(String[] args) {
        Result<String> message = new Result<>();
        Result<Integer> data = new Result<>();

        message.set("hello world!!");
        data.set(3);

        System.out.println(message);
        System.out.println(data);
    }
}
