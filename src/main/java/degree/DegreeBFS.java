package degree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DegreeBFS {
    
    private Graph g;
    
    private Deque<Integer> q;
    Map<Integer, Integer> degreeMap;
    boolean[] marked;
    
    public DegreeBFS(Graph g) {
        this.g = g;
    }
    
    public int degree(int u, int v) {
        q = new ArrayDeque<Integer>();
        degreeMap = new HashMap<Integer, Integer>();
        marked = new boolean[g.n()];
        
        q.addLast(u);
        degreeMap.put(u, 0);
        
        while(!q.isEmpty()) {
            int vertex = q.pollFirst();
            if(!marked[vertex]) {
                addNeighbours(vertex);
                marked[vertex] = true;
            }
            
            if(degreeMap.containsKey(v))
                break;
        }
        
        if(degreeMap.containsKey(v))
            return degreeMap.get(v);
        
        return -1;
    }

    private void addNeighbours(int vertex) {
        int degree = degreeMap.get(vertex);
        for(Edge e: g.adj(vertex)) {
            int otherVertex = e.other(vertex);
            updateDegree(otherVertex, degree + 1);
            q.addLast(otherVertex);
        }
    }

    private void updateDegree(int otherVertex, int degree) {
        if(!degreeMap.containsKey(otherVertex))
            degreeMap.put(otherVertex, degree);
    }

}
