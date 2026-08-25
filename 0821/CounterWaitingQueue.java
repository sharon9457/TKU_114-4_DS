import java.util.ArrayDeque;
import java.util.Deque;

public class CounterWaitingQueue{
    static String serveNext(Deque<String>waiting){
        String customer = waiting.pollFirst();
        return customer == null ? "EMTY":customer;
    }
    public static void main(String[] args){
        Deque<String> waiting = new ArrayDeque<>();

        waiting.offerLast("01  Kai");
        waiting.offerLast("02 Chita");
        waiting.offerLast("03 Nokoli");
        waiting.offerLast("04 Nyrfier");

        System.out.println("下一位:"+waiting.peekFirst());
        System.out.println("服務:"+serveNext(waiting));
        System.out.println("下一位:"+serveNext(waiting));
        System.out.println("剩餘:"+waiting );

    }
}