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
    }
}
