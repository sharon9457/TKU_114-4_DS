public class BstRangeReport {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
}
public static int min(TreeNode root){
    TreeNode current = root;
    while(current.left != null){
        current = current.left;
    }
    return current.val;
}
public static int max(TreeNode root){
    TreeNode current = root;
    while(current.right != null){
        current = current.right;
    }
    return current.val;
}
public static void printRange(TreeNode root,int low,int high){
    if(low>high){
        int temp = low;
        low = high;
        high = temp;
    }
    printRangehelper(root, low, high);    
}
private static void printRangehelper(TreeNode node,int low,int high){
    if(node == null)return;
    if(node.val >low){
        printRangehelper(node.left, low, high);
    }
    if(node.val >= low &&node.val <=high){
        System.out.println(node.val+" ");
    }
    if(node.val <high){
        printRangehelper(node.right, low, high);
    }
}
 public static void main(String[] args) {
        
    TreeNode root1 = new TreeNode(11);
    root1.left = new TreeNode(25);
      root1.right = new TreeNode(33);
      root1.left.left = new TreeNode(48);
      root1.left.right = new TreeNode(55);
      root1.right.left = new TreeNode(60);
      root1.right.right = new TreeNode(72);
      printRange(root1, 10, 30);
      printRange(root1, 64, 23);
      printRange(root1, 100, 200);
}}