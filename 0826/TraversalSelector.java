import java.beans.Expression;
import java.util.ArrayList;
import java.util.List;

class ReviewNode{
    String value;
    ReviewNode left;
    ReviewNode right;

    ReviewNode(String value){
        this.value = value;
    }
}
class  ReviewBst{
     ReviewNode root;
    public void printPrefix(){
        System.out.println("Preorder:");
        preorder(root);
        System.out.println();
    }private void preorder(ReviewNode node){
        if(node == null)return;
        System.out.println(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    private void inorder(ReviewNode node){
        if(node == null)return;
        boolean isOperator = (node.left != null || node.right != null);
        if(isOperator){
            System.out.print("(");
        }inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
        if(isOperator){
            System.out.println(")");
        }
    }
    public void printInfix(){
        System.out.println("Inorder:");
        inorder(root);
        System.out.println();
    }
    
    

public void printPostfix(){
    System.out.println("Postorder:");
    postorder(root);
    System.out.println();
}
private void postorder(ReviewNode node){
    if(node == null)return;
    postorder(node.left);
    postorder(node.right);
    System.out.println(node.value +" ");
}}
public class TraversalSelector{
    public static void main(String[] args) {
        ReviewBst tree = new ReviewBst();

        tree.root = new ReviewNode("*");
        tree.root.left = new ReviewNode("+");
        tree.root.right = new ReviewNode("-");

        tree.root.left.left = new ReviewNode("A");
        tree.root.left.right = new ReviewNode("A");

         tree.root.right.left = new ReviewNode("C");
        tree.root.right.right = new ReviewNode("D");

        tree.printPrefix();
        tree.printInfix();
        tree.printPostfix();
    }}


