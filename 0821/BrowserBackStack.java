import java.util.ArrayDeque;
import java.util.Deque;

public class BrowserBackStack {
    private Deque<String> history;

    public BrowserBackStack(){
        history = new ArrayDeque<>();
    }
    public void visit(String url){
        history.push(url);
        System.out.println("造訪:"+url);    
    }
    public void back(){
        if(history.isEmpty()){
            System.out.println("失敗:未開啟和網頁");
        }else if(history.size() == 1){
            System.out.println("失敗:無法再返回");
        }else{
            String leftPage = history.pop();
            System.out.println("離開"+leftPage+",回上一頁"+history.peek());
        }
    }
    public void current(){
        if(history.isEmpty()){
          System.out.println("空白頁");
        }else {
        System.out.println(history.peek());
    }
    public static void main(String[] args) {
        BrowserBackStack browser = new BrowserBackStack();

        browser.current();
        browser.back();

        browser.visit("Google");
        browser.visit("Dcord");
        browser.visit("youtube");

       browser.current();
       browser.back();
       browser.back();
       browser.back();
       browser.current();

    }
}
