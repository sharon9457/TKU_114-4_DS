

public class BstSearchTrace {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }public static void search(TreeNode root,int target){
        int compCount =0;
        TreeNode current = root;
        while(current !=null){
            compCount++;
            System.out.println(compCount+"節點值:"+current.val);

            if(target == current.val){
                System.out.println("已找到:"+target+"總次數:"+compCount);
                return;
            }
            else if(target<current.val){
                System.out.println(target+"往左移動");
                current = current.left;
            }else{
                System.out.println(target+"往右移動");
                current = current.right;
            }
        }
    }
    public static void main(String[] args) {
        
    TreeNode root1 = new TreeNode(1);
    root1.left = new TreeNode(2);
      root1.right = new TreeNode(3);
      root1.left.left = new TreeNode(4);
      root1.left.right = new TreeNode(5);
      root1.right.left = new TreeNode(6);
      root1.right.right = new TreeNode(7);
      search(root1, 5);
}
}