public class OrderBstSystem {    
    static class Order{
        String id;
        int money;
        String name;

        Order(String id,int money ,String name){
            this.id = id;
            this.money = money;
            this.name = name;

        }    
    public String toString(){
        return"編號:"+ id +"姓名" + name+"金額:"+money;
    }
}
    static class Node{
        Order data;
        Node left;
        Node right;

        Node(Order data){
            this.data = data;
        }
    }
    public static Node add(Node root,Order neworder){
        if(root == null)return new Node(neworder);
        
        int cmp = neworder.id.compareTo(root.data.id);
        if(cmp<0){
            root.left = add(root.left,neworder);
        }else if(cmp>0){
            root.right = add(root.right,neworder);
        }
        return root;
    }
    public static Order find(Node root,String targetid){
        if(root == null){
            return null;
        }
        int cmp = targetid.compareTo(root.data.id);
        if(cmp ==0){
            return root.data;
        }else if(cmp<0){
            return find(root.left,targetid);
        }else{
            return find(root.right,targetid);
        }
    }
    
    public static void change(Node root,String targetid,int newamount){
        Order target = find(root, targetid);
        if(target != null){
            target.money=newamount;
            System.out.println(targetid+"修改為:"+newamount);
        }else{
            System.out.println("false");
        }
    }        
    private static void report(Node root,String min,String max){        
        if(root ==null){
            return ;
        }
        if(root.data.id.compareTo(min)>=0){
            report(root.left, min, max);
        }
        if(root.data.id.compareTo(min)>=0 &&root.data.id.compareTo(max)<=0){
            System.out.println(" "+root.data.toString());
        }
        if(root.data.id.compareTo(max)<=0){
            report(root.right, min, max);
        }
    }
    public static void summary(Node root){
        int[] stats = new int[2];
        calculate(root,stats);
        System.out.println("訂單數:"+stats[0]);
        System.out.println("總收入:"+stats[1]);
    }
    public static void calculate(Node node,int[] stats){
        if(node == null) return;
        stats[0]++;
        stats[1] += node.data.money;
        calculate(node.left,stats);
        calculate(node.right,stats);
    }
    public static void printInorder(Node root){
        if(root == null)return;
        printInorder(root.left);
        System.out.println(root.data.toString());
        printInorder(root.right);
    }
    public static Node delete(Node root,String targetid){
        if(root == null)return null;
        int cmp = targetid.compareTo(root.data.id);

        if(cmp<0){
            root.left = delete(root.left,targetid);
        }else if(cmp>0){
            root.right = delete(root.right,targetid);
        }else{
            if(root.left == null)return root.right;
            if(root.right == null)return root.left;
        
        Node min = getmin(root.right);
        root.data =min.data;
        root.right = delete(root.right,min.data.id);
    }
    return root;
}
private static Node getmin(Node node){
    while (node.left != null){
        node = node.left; 
    }
        return node;
    }
    public static void main(String[] args) {
        Node root = null;
       
        root = add(root,new Order("001",900,"chita" ));
        root = add(root,new Order("005",1200,"nokori" ));
       root = add(root,new Order("003",1900,"nyfier" ));
       root = add(root,new Order("008",800,"kai" ));
        printInorder(root);
        System.out.println();    
        change(root, "00l",6000);
        System.out.println();
        report(root, "005","008");
        System.out.println();
        summary(root);
        System.out.println();
        summary(root);
        root =delete(root, "005");
        printInorder(root);   
        
    }
}