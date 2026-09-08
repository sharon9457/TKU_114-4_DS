import java.util.ArrayList;
import java.util.List;
public class MenuTreeSearch {
    static class MenuNode{
    String name;
    List<MenuNode>children;

    MenuNode(String name){
        this.name = name;
        this.children = new ArrayList<>();
    }
    void addChild(MenuNode child){
        this.children.add(child);
    }
}
public static void display(MenuNode node,String indent){
    if(node == null) return;
    for(MenuNode child:node.children){
        display(node, indent);
    }
}
public static boolean contains(MenuNode node,String target){
    if(node == null)return false;
    if(node.name.equals(target))return true;
    for(MenuNode child : node.children){
        if(contains(child,target)){
            return true;
        }
    }
    return false;
}
public static int findDepth(MenuNode root,String target){
    return findDepthhelper(root, target,0);
}
private static int findDepthhelper(MenuNode node,String target,int current){
    if(node == null) return -1;
    if(node.name.equals(target))return current;

    for(MenuNode child:node.children){
        int depth = findDepthhelper(child, target,current+1);
        if(depth != -1){
            return depth;
        }
    }
    return -1;
}
public static int countleaves(MenuNode node){
    if(node.children.isEmpty()){
        return 1;
    }
    if(node.children.isEmpty()){
        return 1;
    }
    int total =0;
    for(MenuNode child:node.children){
        total +=countleaves(child);
    }return total;
}
public static void main(String[] args) {
    MenuNode root = new MenuNode("Main Menu");
    MenuNode file = new MenuNode("File");
    file.addChild(new MenuNode("open"));
    file.addChild(new MenuNode("close"));
    file.addChild(new MenuNode("del"));
    file.addChild(new MenuNode("save"));
    file.addChild(new MenuNode("cul"));
    
    System.out.println("save"+contains(root, "save"));
    System.out.println("深度:"+findDepth(root, "save"));
    System.out.println("總點數"+countleaves(root));
}}
