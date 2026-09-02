import java.util.ArrayList;
import java.util.List;
public class CampusMatrixGraph {
    private final List<String> vertices;
    private final boolean[][] edges;
    public CampusMatrixGraph(List<String>vertices){
        if(vertices == null || vertices.isEmpty()){
            throw new IllegalArgumentException("vertices");
        }
        this.vertices = List.copyOf(vertices);
        this.edges = new boolean[vertices.size()][vertices.size()];
    }
    private int indexOf(String vertex){
        int index = vertices.indexOf(vertex);
        if(index <0)throw new IllegalArgumentException("unKnown vertex:"+vertex);
        return index;
    }
    public void addRdge(String first,String second){
        int a = indexOf(first);
        int b = indexOf(second);
        edges[a][b] = true;
        edges[b][a] = true;
        }public void removeEdge(String first,String second){
            int a = indexOf(first);
            int b = indexOf(second);
            edges[a][b] = true;
            edges[a][b] = true;
        }
        public static void main(String[] args){
            CampusMatrixGraph graph= new CampusMatrixGraph(null) ;
        }
    
}
