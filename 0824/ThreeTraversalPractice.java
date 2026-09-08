import java.util.ArrayList;
import java.util.List;
public class ThreeTraversalPractice {
    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;

        TreeNode(String val){
            this.val = val;
        }
    }
    public static List<String>preorder(TreeNode root){
        List<String>result = new ArrayList<>();
        preorderhelper(root,result);
        return result;
    }
    private static void preorderhelper(TreeNode node,List<String>result){
        if(node == null)return;
        result.add(node.val);
        preorderhelper(node.left, result);
        preorderhelper(node.right, result);
    }
    public static List<String>inderder(TreeNode root){
        List<String>result = new ArrayList<>();
        inderhelper(root,result);
        return result;
    }
    private static void inderhelper(TreeNode node,List<String>result){
         if(node == null)return;
        inderhelper(node.left, result);
        result.add(node.val);
        inderhelper(node.right, result);
    }
    public static List<String>postorder(TreeNode root){
        List<String>result = new ArrayList<>();
        postorderhelper(root,result);
        return result;
    }
    private static void postorderhelper(TreeNode node,List<String>result){
         if(node == null)return;
        postorderhelper(node.left, result);
        postorderhelper(node.right, result);
        result.add(node.val);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F");
        root.right.right = new TreeNode("G");

        System.out.println("preorder:"+preorder(root));
        System.out.println("inorder:"+inderder(root));
        System.out.println("postorder:"+postorder(root));
    }    
}
