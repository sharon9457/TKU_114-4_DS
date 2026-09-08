import java.util.ArrayList;
import java.util.List;
public class SkewedBstReport {
    
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    public static TreeNode insert(TreeNode root,int val){
        if(root == null)return new TreeNode(val);

        if(val<root.val){
            root.left = insert(root.left, val);
        }else if(val > root.val){
            root.right = insert(root.right, val);
        }
        return root;
    }
    private static void sequence(int[] sortedData,int start,int end,List<Integer> result){
        if(start>end)return;
        int mid = start +(end-start)/2;
        result.add(sortedData[mid]);
        sequence(sortedData, start, mid -1, result);
        sequence(sortedData, mid +1, end, result);
    }
    public static int getsize(TreeNode root){
        if(root == null)return 0;
        return 1+ getsize(root.left)+getsize(root.right);
    }
    public static int getheight(TreeNode root){
        if(root == null)return -1;
        return 1+ Math.max(getheight(root.left),getheight(root.right));
    }
    public static int searchcount(TreeNode root,int target){
        int count =0;
        TreeNode current = root;

        while (current != null) {
            count++;
            if(current.val == target){
                return count;
            }
            else if(target < current.val){
                current = current.left;
            }else{
                current = current.right;
            }
        }return count;
    }
    private static void printMetrics(TreeNode root,int searchTarget){
        System.out.println("size"+getsize(root));
        System.out.println("height"+getheight(root));
        System.out.println(searchTarget+"次數"+searchcount(root,searchTarget));
    }
    public static void main(String[] args) {
        int target =15;
        int[] data = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        TreeNode root =null;
        for(int val:data){
            root = insert(root, val);
        }
        List<Integer>balance = new ArrayList<>();
        sequence(data, 0,data.length-1, balance);

        TreeNode balanceroot = null;
        for(int val:balance){
            balanceroot = insert(balanceroot, val);
        }
        
        printMetrics(balanceroot, target);
    }
}
