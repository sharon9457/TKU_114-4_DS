import org.w3c.dom.Node;

public class StudentBstIndex {
    
    static class Student{
        int studentid;
        String name;
        Student(int studentid,String name){
            this.studentid = studentid;
            this.name = name;
        }
    
    public String toString(){
        return studentid + ":" + name;
    }}
    static class Node{
        Student data;
        Node left;
        Node right;

        Node(Student data){
            this.data = data;
        }
    }
    public static Node insert(Node root,Student newstudent){
        if(root == null){
            return new Node(newstudent);
        }
        if(newstudent.studentid<root.data.studentid){
            root.left = insert(root.left,newstudent);
        }else if(newstudent.studentid>root.data.studentid){
            root.right = insert(root.right,newstudent);
        }
        return root;
    }
    public static Student search(Node root,int targetid){
        if(root == null){
            return null;
        }
        if(targetid == root.data.studentid){
            return root.data;
        }else if(targetid<root.data.studentid){
            return search(root.left,targetid);
        }else{
            return search(root.right,targetid);
        }
    }
    
    public static Node delete(Node root,int targetid){
        if(root == null)return null;

        if(targetid < root.data.studentid){
            root.left = delete(root.left, targetid);
        }else if(targetid>root.data.studentid){
            root.right = delete(root.right, targetid);
        }else{
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            Node miNode = getmin(root.right);
            root.data = miNode.data;
            root.right = delete(root.right, miNode.data.studentid);
        }
        return root;
    }

    private static Node getmin(Node node){
        while(node.left != null){
           node = node.left;
        }
        return node;
    }
    private static void searchprint(Node root,int targetid){
        Student result = search(root, targetid);
        if(result !=null){
            System.out.println(targetid+","+result.name);
        }
    }
    public static void printInorder(Node root){
        if(root == null)return;
        printInorder(root.left);
        System.out.println(root.data.toString());
        printInorder(root.right);
    }
    public static void main(String[] args) {
        Node root = null;
       
        root = insert(root,new Student(001,"chita" ));
        root = insert(root,new Student(002,"nokori" ));
        root = insert(root,new Student(003,"kai" ));
        root = insert(root,new Student(004,"nyrfier" ));
        root = insert(root,new Student(005,"petter" ));
        printInorder(root);
        System.out.println();

        root = insert(root, new Student(005, "Garry"));
        search(root,004);
        search(root, 10);
        System.out.println();
        root = delete(root, 005);
        printInorder(root);

    }
}
