import java.util.Arrays;

class CircularIntQueue<T>{
    private final Object[] data;
    private int front;
    private int rear;
    private int size;

    CircularIntQueue(int capacity){
        data = new Object[Math.max(1,capacity)];
    }
    boolean enqueue(T value){
        if(isFull()){
            return false;
        }
        data[rear] = value;
        rear = (rear +1)%data.length;
        size++;
        return true;
    }
    public T dequeue(){
        if(isEmpty()){
            return null;
        }
        T value = (T)data[front];
        data[front] = null;
        front = (front+1)%data.length;
        size--;
        return value;
    }

    public T peek(){
        return isEmpty()?null:(T) data[front];
    }
    boolean isEmpty(){
        return size ==0;
    }
    boolean isFull(){
        return size == data.length;
    }
    public void printState(String action){
        System.out.println(Arrays.toString(data)+"front="+front+"rear="+rear+"size="+size);
    }
}
public class CircularQueuePractice {
    public static void main(String[] args) {
        CircularIntQueue queue = new CircularIntQueue(3);
        queue.enqueue(10);
         queue.enqueue(50);
         queue.printState("enqueue A");

         System.out.println("dequeue="+queue.dequeue());
         queue.enqueue(100);
         queue.enqueue(150);
         queue.printState("enqueue C");

         System.out.println("full="+queue.isFull());
         System.out.println("enqueue 200="+queue.enqueue(200));
         System.out.println("peek="+queue.peek());
    }
}
