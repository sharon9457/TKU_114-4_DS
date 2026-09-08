import java.util.ArrayList;
import java.util.List;
public class BstDeleteCases {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode delete(TreeNode root,int key){
        if(root == null)return null;
        if(key<root.val){
            root.left = delete(root.left,key);
        }else if(key>root.val){
            root.right = delete(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }
            TreeNode min = getmin(root.right);
            root.val = min.val;

            root.right = delete(root.right, min.val);
        }
        return root;
    }
    private static TreeNode getmin(TreeNode node){
        
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
    private static List<Integer>getInorder(TreeNode root){
        List<Integer>result = new ArrayList<>();
        inorderhelper(root, result);
        return result;
    }
    private static void inorderhelper(TreeNode node,List<Integer> result){
        if(node == null)return;
        inorderhelper(node.left, result);
        result.add(node.val);
        inorderhelper(node.right, result);
    }
    private static int getsize(TreeNode node){
        if(node == null) return 0;
        return 1+getsize(node.left)+getsize(node.right);
    }

    private static boolean isvalid(TreeNode node,Integer min,Integer max){
        if(node == null)return true;
        if((min != null &&node.val <=min)||(max !=null && node.val >=max)){
            return false;
        }
        return isvalid(node.left, min,node.val)&&isvalid(node.right, node.val, max);
    }
    private static void printstatus(TreeNode root){
        System.out.println("inorder:"+getInorder(root));
        System.out.println("size:"+getsize(root));
        System.out.println(isvalid(root,null,null));
    }
    
    public static void main(String[] args) {
        
    TreeNode root1 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1.right = new TreeNode(79);
      root1.left.left = new TreeNode(12);
      root1.left.right = new TreeNode(38);
      root1.right.left = new TreeNode(59);
      root1.right.right = new TreeNode(81);
      printstatus(root1);
      root1 = delete(root1,38);
      printstatus(root1);
      root1 = delete(root1,34);
      printstatus(root1);
      root1 = delete(root1,57);
      printstatus(root1);      
}
}
