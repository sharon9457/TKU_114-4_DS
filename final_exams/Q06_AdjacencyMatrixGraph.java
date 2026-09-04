import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Q06_AdjacencyMatrixGraph {
private final List<String> vertices;
private final Map<String,Integer>indexMap;
private final boolean[][]matrix;
    public Q06_AdjacencyMatrixGraph(java.util.List<String> vertices){
        this.vertices = new ArrayList<>(vertices);
        this.indexMap = new HashMap<>();
        int size = this.vertices.size();

        for(int x =0;x<size;x++){
            this.indexMap.put(this.vertices.get(x),x);
                    }
             this.matrix = new boolean[size][size];
    }
    private int getIndex(String vertex){
        if(vertex == null)return -1;
        return indexMap.getOrDefault(vertex,-1);
    }
public boolean addEdge(String first, String second){
    int i = getIndex(first);
    int j = getIndex(second);

    if(i == -1||j==-1||i ==j){
        return false;
    }
    if(matrix[i][j]){
        return false;
    }
    matrix[i][j]=true;
    matrix[j][i] = true;
    return true;
}
public boolean removeEdge(String first, String second){
    int i = getIndex(first);
    int j = getIndex(second);
    if(i ==-1||j ==-1||!matrix[i][j]){
        return false;
    }
    matrix[i][j] = false;
    matrix[j][i] = false;
    return true;
}
public boolean hasEdge(String first, String second){
    int i = getIndex(first);
    int j = getIndex(second);
    if(i ==-1||j ==-1){
        return false;
    }
    return matrix[i][j];    
}

public int degree(String vertex){
    int i = getIndex(vertex);
    if(i == -1){
        return 0;
    }
    int count =0;
    for(boolean edge:matrix[i]){
        if(edge)count++;
    }
    return count;
}
public java.util.List<String> neighbors(String vertex){
    int i = getIndex(vertex);
    if(i ==-1){
        return Collections.emptyList();
    }
    List<String>result = new ArrayList<>();
    for(int j =0;j<matrix[i].length;j++){
        if(matrix[i][j]){
            result.add(vertices.get(j));
        }
    }
    return result;
}
public static void main(String[] args){
    Q06_AdjacencyMatrixGraph graph = new Q06_AdjacencyMatrixGraph(List.of("A","B","C"));
    boolean test1 = graph.addEdge("A","B") == true;
    boolean test2 = graph.addEdge("B","C") == true;
    boolean test3 = graph.addEdge("A","C") == true;
    boolean test4 = graph.addEdge("A","A") == false;
    boolean test5 = graph.addEdge("A","Y") == false;
    System.out.println(test1+","+test2+","+test3+","+test4+","+test5);
}
}