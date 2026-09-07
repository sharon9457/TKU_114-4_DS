import java.util.ArrayList;
import java.util.List;

public class BinaryTreeStructureReport {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    

public static void printree(TreeNode root){
    System.out.println("Root"+(root == null ?"null":root.val));
    System.out.println("leaves"+getLeaves(root));
    System.out.println("size"+getsize(root));
    System.out.println("leaf count"+getleafcount(root));
    System.out.println("height"+getheight(root));
}
public static List<Integer> getLeaves(TreeNode node){
    List<Integer> leaves = new ArrayList<>();
    collectLeaves(node,leaves);
    return leaves;
} 
private static void collectLeaves(TreeNode node,List<Integer>leaves){
    if(node == null) return;
    if(node.left == null && node.right == null){
        leaves.add(node.val);
    }
    collectLeaves(node.left, leaves);
    collectLeaves(node.right,leaves);
}
public static int getsize(TreeNode node){
    return 1 +getsize(node.left)+getsize(node.right);
} 
private static int getleafcount(TreeNode node){
    if(node == null) return 0;
    if(node.left == null && node.right == null)
        return 1;
        return getleafcount(node.left)+getleafcount(node.right);
    
}   
public static int getheight(TreeNode node){
    if(node == null)return -1;
    int leftheight = getheight(node.left);
    int rightheight = getheight(node.right);

    return 1 +Math.max(leftheight,rightheight);
}   

public static void main(String[] args){
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
      root1.right = new TreeNode(3);
      root1.left.left = new TreeNode(4);
      root1.left.right = new TreeNode(5);
      root1.right.left = new TreeNode(6);
      root1.right.right = new TreeNode(7);
      System.out.println("root1");
      printree(root1);
}}

