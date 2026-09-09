public class ScoreRangeBst {
    static class Node{
        int score;
        String id;
        String name;
        Node left;
        Node right;
        Node(int score,String id,String name){
            this.score = score;
            this.id = id;
            this.name = name;
        }
        public String toString(){
            return "分數"+score+"學號"+id+"姓名"+name;
        }
    }
    public static Node insert(Node root,int score,String id,String name){
        if(root == null){
            return new Node(score, id, name);
             }
             if(score <root.score){
                root.left = insert(root.left,score,id,name);
             }
             else if(score>root.score){
                root.right = insert(root.right,score,id,name);
             }
             else{
                int cmp =id.compareTo(root.id);
                if(cmp<0){
                    root.left = insert(root.left, score, id, name);
                }else if(cmp>0){
                    root.right = insert(root.right,score,id,name);
                }else{
                    System.out.println("以新增");
                }
             }
             return root;
    }
    public static void printScoreRangge(Node root,int min,int max){
        if(root == null)return;
        if(root.score >=min){
            printScoreRangge(root.left, min, max);
        }
        if(root.score<=max){
            printScoreRangge(root.right, min, max);
        }
        if(root.score>=min &&root.score<=max){
            System.out.println(root.toString());
        }
    }
    public static void main(String[] args){
        Node root = null;
        root = insert(root, 98, "001",  "chita");
        root = insert(root, 68, "003",  "nokori");
        root = insert(root, 90, "002",  "kai");
        root = insert(root, 56, "007",  "petter");
        root = insert(root,  98, "005", "nyrfier");    
        printScoreRangge(root, 80,100);  
      }
   
}
