import java.util.ArrayList;
import java.util.List;
public class BstDeleteTestSuite {
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
        if(key <root.val){
            root.left = delete(root.left, key);
        }if(key >root.val){
            root.right = delete(root.left, key);
        }else{
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
        TreeNode min = getmin(root.right);
        root.val = min.val;
        root.right = delete(root.right, min.val);
    } return root;
}
private static TreeNode getmin(TreeNode node){
    while(node.left != null){
        node = node.left;
    }
    return node;
}
private static List<Integer>getInorder(TreeNode root){
    List<Integer>result = new ArrayList<>();
    inorderhelper(root,result);
    return result;
}
private static void inorderhelper(TreeNode node,List<Integer>result){
    if(node == null)return;
    inorderhelper(node.left, result);
    result.add(node.val);
    inorderhelper(node.right, result);
}
private static void printTest(String tname,TreeNode root, String expected){
    String actual = getInorder(root).toString();
    System.out.println(actual+","+expected);
    if(actual.equals(expected)){
        System.out.println("pass");
    }else{
        System.out.println("false");
    }}
    public static void main(String[] args) {
            
    TreeNode root1 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1 =delete(root1, 50);
     System.out.println(root1+"不存在");

     TreeNode root2 = new TreeNode(34);
    root2= delete(root2, 34);            
    System.out.println("刪除"+root2);

    TreeNode root3 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1.right = new TreeNode(79);
      root1.left.right = new TreeNode(38);
      root1.right.left = new TreeNode(59);
      delete(root3, 57);
     System.out.println("已刪除"+root3);

     TreeNode root4 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1.right = new TreeNode(79);
      root1.left.left = new TreeNode(12);
      root1.left.right = new TreeNode(38);
      root1.right.left = new TreeNode(59);
      int[]delete = {57,34,79,12,38,59};
      System.out.println(getInorder(root4));
      for(int val:delete){
        root4 = delete(root4, val);
        System.out.println(getInorder(root4));
      }         
     System.out.println(root4==null?"已清空":"未清空");
    
     TreeNode root5 =null;
     root5 =delete(root2, 34);            
    System.out.println("刪除"+root5);

    TreeNode root6 = new TreeNode(57);
    root6.left = new TreeNode(34);
    root6.left.left = new TreeNode(45);
      root1 =delete(root1, 57);
     System.out.println(root6+"已刪除");
}
    }
   

