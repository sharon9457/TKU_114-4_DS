public class BstDuplicateCounter {
    private TreeNode root;
    static class TreeNode{
        int key;
        int count;
        TreeNode left;
        TreeNode right;    
    TreeNode(int key){
        this.key = key;
        this.count = 1;
    }
}
public void insert(int key){
    root = inserRec(root,key);
}
private TreeNode inserRec(TreeNode node,int key){
    if(node == null){
        return new TreeNode(key);
    }
    if(key == node.key){
        node.count++;
    }
    else if(key<node.key){
        node.left = inserRec(node.left, key);
    }else{
        node.right = inserRec(node.right, key);
    }
    return node;
}
public void inorder(){
    inorderRec(root);
    System.out.println();
}
private void inorderRec(TreeNode node){
    if(node != null){
        inorderRec(node.left);
        System.out.println(node.key+","+node.count);
        inorderRec(node.right);
    }
}
public static void main(String[] args) {
    BstDuplicateCounter x =new BstDuplicateCounter();
    int[] data = {10,23,57,32,89,23,43,57};
    for(int val:data){
        System.out.println(val+"");
        x.insert(val);
    }
    x.inorder();
}
}
