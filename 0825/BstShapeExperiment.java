import java.util.ArrayList;
import java.util.List;

public class BstShapeExperiment {
    
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
        if(val <root.val)root.left = insert(root.left, val);
        else if(val>root.val)root.right = insert(root.right,val);
        return root;
    }
    public static int getheight(TreeNode root){
        if(root == null)return -1;
        return 1+Math.max(getheight(root.left),getheight(root.right));
    }
    public static int getcount(TreeNode root,int target){
        int count =0;
        TreeNode curr = root;
        while(curr != null){
            count++;
            if(target == curr.val)return count;
            else if(target <curr.val)curr = curr.left;
            else curr = curr.right;
        }
        return count;
    }
    public static int gettotalcount(TreeNode root,int[] allValues){
        int total =0;
        for(int val:allValues){
            total +=getcount(root, val);
        }
        return total;
    }
    private static void generatebalance(int[] sortedData,int start,int end ,List<Integer>result){
        if(start>end)return;
        int mid = start+(end-start)/2;
        result.add(sortedData[mid]);
        generatebalance(sortedData, start, mid-1, result);
        generatebalance(sortedData, mid+1, end, result);
    }
    private static void printMetrics(String name,TreeNode root,int[] allValues){
        System.out.println(name);
        System.out.println("height:"+getheight(root));
        System.out.println("time:"+gettotalcount(root, allValues));
    }
    public static void main(String[] args) {
        
        int[] sdata={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        int[] rdata ={32,56,34,87,25,49,4,23,45,36,57,90,81,72,60};

        List<Integer>balanceLiist = new ArrayList<>();
        generatebalance(sdata, 0, sdata.length-1, balanceLiist);

        TreeNode skewedroot = null;
        for(int val:sdata)skewedroot = insert(skewedroot, val);
        TreeNode randomRoot = null;
        for(int val:rdata)randomRoot = insert(randomRoot, val);
        TreeNode balanceroot = null;
        for(int val:balanceLiist)balanceroot = insert(balanceroot, val);
        printMetrics("skewed",skewedroot,sdata);
        printMetrics("random",randomRoot,sdata);
        printMetrics("balance",balanceroot,sdata); 
}}
