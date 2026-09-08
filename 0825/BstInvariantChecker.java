

public class BstInvariantChecker {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
    public static boolean isvalid(TreeNode node,Integer min,Integer max){
        if(node == null)return true;
    
    if((min !=null && node.val <=min)||(max !=null &&node.val >=max)){
        return false;
    }
    return isvalid(node.left,min,node.val)&&isvalid(node.right,node.val,max);
}

    public static void main(String[] args) {
        
    TreeNode root1 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1.right = new TreeNode(79);
      root1.left.left = new TreeNode(12);
      root1.left.right = new TreeNode(38);
      root1.right.left = new TreeNode(59);
      root1.right.right = new TreeNode(81);
     System.out.println(isvalid(root1, null, null));

     TreeNode root2 = new TreeNode(34);
    root1.left = new TreeNode(12);
      root1.right = new TreeNode(44);
      root1.left.left = new TreeNode(13);
      root1.left.right = new TreeNode(50);      
     System.out.println(isvalid(root2, null, null));

     TreeNode root3 = new TreeNode(57);
    root1.left = new TreeNode(34);
      root1.right = new TreeNode(79);
      root1.left.left = new TreeNode(12);
      root1.left.right = new TreeNode(38);
      root1.right.left = new TreeNode(59);
      root1.right.right = new TreeNode(81);
       root1.left.right.right = new TreeNode(58);
     System.out.println(isvalid(root3, null, null));
}
}
