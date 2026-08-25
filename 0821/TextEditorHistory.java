import java.util.ArrayDeque;
import java.util.Deque;

class TextEditorHistory{
    private final Deque<String>uStack;
    private final Deque<String>rStack;

    public TextEditorHistory(){
        this.uStack = new ArrayDeque<>();
        this.rStack = new ArrayDeque<>();
    }
    public void type(String text){
        uStack.push(text);
        rStack.clear();
        System.out.println(text);
    }
    public void undo(){
        if(uStack.isEmpty()){
            return;
        }
        String action = uStack.pop();
        rStack.push(action);
        }
        public void redo(){
             String action = rStack.pop();
        uStack.push(action);
        }
       private void printState(String action){
        System.out.println(action + "Undo Stack:" + uStack + "Redo Stack" + rStack );
       }
       public static void mani(String[] args){
        TextEditorHistory t = new TextEditorHistory();
        

        t.type("A");
         t.type("B");
          t.type("C");

         t.undo();

         t.redo();
         t.type("D");
         t.undo();
       }}
       
       