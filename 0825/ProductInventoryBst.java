

public class ProductInventoryBst {
    
    static class Product{
        int id;
        int number;
        String name;

        Product(int id,int number,String name){
            this.id = id;
            this.number = number;
            this.name = name;

        }
    
    public String toString(){
        return"編號:"+ id +"商品名稱" + name+"數量:"+number;
    }}
    static class Node{
        Product data;
        Node left;
        Node right;

        Node(Product data){
            this.data = data;
        }
    }
    public static Node insert(Node root,Product newproduct){
        if(root == null){
            return new Node(newproduct);
        }
        if(newproduct.id<root.data.id){
            root.left = insert(root.left,newproduct);
        }else if(newproduct.id>root.data.id){
            root.right = insert(root.right,newproduct);
        }
        return root;
    }
    public static Product search(Node root,int targetid){
        if(root == null){
            return null;
        }
        if(targetid == root.data.id){
            return root.data;
        }else if(targetid<root.data.id){
            return search(root.left,targetid);
        }else{
            return search(root.right,targetid);
        }
    }
    
    public static Node delete(Node root,int targetid){
        if(root == null)return null;

        if(targetid < root.data.id){
            root.left = delete(root.left, targetid);
        }else if(targetid>root.data.id){
            root.right = delete(root.right, targetid);
        }else{
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
            Node miNode = getmin(root.right);
            root.data = miNode.data;
            root.right = delete(root.right, miNode.data.id);
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
        Product result = search(root, targetid);
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
       
        root = insert(root,new Product(001,23,"掛軸" ));
        root = insert(root,new Product(002,63,"娃娃" ));
        root = insert(root,new Product(003,13,"拍立得" ));
        root = insert(root,new Product(004,56,"公仔" ));
        printInorder(root);
        System.out.println();

        root = insert(root, new Product(005,77, "立牌"));
        search(root,4);
        search(root, 10);
        System.out.println();
        root = delete(root, 2);
        printInorder(root);
    }
}
