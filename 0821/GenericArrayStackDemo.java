class ArrayStack<T>{
    private Object[] data;
   
    private int capacity;
    private int size;

public ArrayStack(int capacity){
    this.capacity = Math.max(1,capacity);
    this.data = new Object[this.capacity];
    this.size =0;
}
boolean push(String value){
    if(value ==null || isFull()){
        return false;
    }
    data[size] = value;
    size++;
    return true;
}
public T pop(){
    if(isEmpty()){
        return null;
    }
    size--;
    T value = (T)data[size];
    data[size ] = null;
    return value;
}
public T peek(){
    return isEmpty() ?null:(T)data[size -1];
}
public int size(){
    return size;
}
public boolean isEmpty(){
    return size ==0;
}
public boolean isFull(){
    return size ==capacity;
}
}
public class GenericArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(2);

        System.out.println("push A:"+stack.push("A"));
        System.out.println("push B:"+stack.push("B"));
        System.out.println("push B:"+stack.push("B"));
        System.out.println("peek:"+stack.peek());
        System.out.println("pop:"+stack.pop());
        System.out.println("size:"+stack.size());

    }
}
