import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
public class TraversalResultCollector {
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
    public static List<String>levelorder(TreeNode root){
        List<String>result = new ArrayList<>();
        levelorderhelper(root,result);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode current = queue.poll();
            result.add(current.val);

            if(current.left !=null){
                queue.offer(current.left);
            }
            if(current.right != null){
                queue.offer(current.right);
            }
        }
        return result;
    }
    private static void levelorderhelper(TreeNode node,List<String>result){
         if(node == null)return;
        postorderhelper(node.left, result);
        postorderhelper(node.right, result);
        result.add(node.val);
    }
    private static void printresults(String title,TreeNode root){
         System.out.println("preorder:"+preorder(root));
        System.out.println("inorder:"+inderder(root));
        System.out.println("postorder:"+postorder(root));
        System.out.println("levelorder:"+levelorder(root));

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode("A");
        root.left = new TreeNode("B");
        root.right = new TreeNode("C");
        root.left.left = new TreeNode("D");
        root.left.right = new TreeNode("E");
        root.right.left = new TreeNode("F");
        root.right.right = new TreeNode("G");
        printresults("complete tree", root);

       
        TreeNode leftskewed = new TreeNode("A");
        root.left = new TreeNode("B");        
        root.left.left = new TreeNode("D");       
        printresults("leftskewed", leftskewed);

        TreeNode single = new TreeNode("A");
        printresults("single", single);

        TreeNode empty = null;
        printresults("empty", empty);      
    }    
}
