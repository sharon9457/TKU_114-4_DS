import java.util.LinkedList;
import java.util.Queue;
public class LevelOrderByLine {
     static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val){
            this.val = val;
        }    
}
public static void printLevelOrder(TreeNode root){
    Queue<TreeNode>queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(root);
    int level =1;
    while(!queue.isEmpty()){
        int levelsize = queue.size();
        System.out.println("level"+level+"count:"+levelsize);
        for(int i =0;i<levelsize;i++){
            TreeNode current = queue.poll();
            System.out.println(current.val+" ");
            if(current.left != null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }System.out.println();
        level++;
    }
}
public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F");
        root.right.right = new TreeNode("G");
        printLevelOrder(root);
}}