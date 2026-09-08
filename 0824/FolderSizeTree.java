import java.util.ArrayList;
import java.util.List;

public class FolderSizeTree {
    static class FolderNode{
        String name;
        int ownsize;
        FolderNode left;
        FolderNode right;

        FolderNode(String name ,int ownsize){
            this.name = name;
            this.ownsize = ownsize;
        }
    }
    static class Stats{
        String maxname ="";
        int maxsize = -1;
        List<String>leftfolders = new ArrayList<>();
    }
    public static int calculate(FolderNode node,Stats stats){
        if(node == null){
            return 0;
        }
        
        int leftsize = calculate(node.left, stats);
        int rightsize = calculate(node.right, stats);

        if(node.left == null && node.right == null){
            stats.leftfolders.add(node.name);
            }

            int currentsize = node.ownsize+leftsize+rightsize;
            if(currentsize>stats.maxsize){
                stats.maxsize = currentsize;
                stats.maxname = node.name;
            }return currentsize;

    }
    public static void main(String[] args) {
    FolderNode root1 = new FolderNode("root",1) ;
    root1.left =new FolderNode("time",2);
      root1.right = new FolderNode("temp",3);
      root1.left.left = new FolderNode("work",4);
      root1.left.right = new FolderNode("cul",5);
      root1.right.left = new FolderNode("del",6);
      root1.right.right = new FolderNode("caps",7);
      Stats stats = new Stats();
      int total = calculate(root1, stats);

      System.out.println("total size:"+total);
      System.out.println("Max:"+stats.maxname+"size:"+stats.maxsize);
      System.out.println("folders"+stats.leftfolders);
    
    }
}
