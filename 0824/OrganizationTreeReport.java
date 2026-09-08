import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class OrganizationTreeReport {
    static class OrgNode{
        String name;
        List<OrgNode> subordinates;

        OrgNode(String name){
            this.name = name;
            this.subordinates = new ArrayList<>();
        }
        void addSubordinate(OrgNode child){
            this.subordinates.add(child);
        }}
        public static void printByLevel(OrgNode root){
            Queue<OrgNode> queue = new LinkedList<>();
                queue.offer(root);
                int level =0;

                while(!queue.isEmpty()){
                    int levelsize = queue.size();
                    System.out.print("level:"+level);

                    for(int i =0;i<levelsize;i++){
                        OrgNode current = queue.poll();
                        System.out.println(current.name);

                        for(OrgNode sub:current.subordinates){
                            queue.offer(sub);
                        }
                    }
                    System.out.println();
                    level++;                    
                }
        }
        public static OrgNode findparent(OrgNode root,String target){
            return findparenthelper(root, target);
        }
        private static OrgNode findparenthelper(OrgNode current,String target){
            for(OrgNode sub:current.subordinates){
                if(sub.name.equals(target)){
                    return current;
                }
                OrgNode found = findparenthelper(sub, target);
                if(found != null){
                    return found;
                }
            }
            return null;
        }

         public static int finddepth(OrgNode root,String target){
            return finddephhelper(root, target,0);
         }
        private static int finddephhelper(OrgNode current,String target,int depth){
            if(current == null)return -1;
            if(current.name.equals(target))return depth;

            for(OrgNode sub:current.subordinates){
                int founddepth = finddephhelper(sub, target,depth+1);
                if(founddepth != -1){
                    return founddepth;
                }
            }
            return -1;
        }
        public static List<String>pathFromRoot(OrgNode root,String target){
            List<String>path = new ArrayList<>();
            if(buildpath(root,target,path)){
                return path;
            }
            return new ArrayList<>();
        }
        private static boolean buildpath(OrgNode current,String target,List<String>path){
            if(current == null) return false;
            path.add(current.name);        
        if(current.name.equals(target)){
            return true;
        }
        for(OrgNode sub:current.subordinates){
            if(buildpath(sub, target, path)){
                return true;
            }
        }
        path.remove(path.size()-1);
        return false;
    }

public static void main(String[] args) {
    OrgNode a = new OrgNode("a");
    OrgNode b = new OrgNode("b");
    OrgNode c = new OrgNode("c");
    OrgNode d = new OrgNode("d");
    OrgNode e = new OrgNode("e");
    OrgNode f = new OrgNode("f");
    a.addSubordinate(b);
    a.addSubordinate(c);
    a.addSubordinate(d);
    a.addSubordinate(e);
    a.addSubordinate(f);

    printByLevel(a);
    System.out.println(findparent(a,"b")!=null?findparent(a,"b").name:"null");
    System.out.println("深度"+finddepth(a,"d"));
    System.out.println("到e 路徑:"+pathFromRoot(a,"e"));
        
}
}
