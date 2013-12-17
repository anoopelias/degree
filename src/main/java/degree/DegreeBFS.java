package degree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * An implementation of Degree using Breadth-First-Search.
 * 
 * @author anoopelias
 *
 */
public class DegreeBFS {
    
    private Graph g;
    
    private Deque<Node> q;
    boolean[] marked;
    
    /**
     * Initialize with graph g.
     * 
     * @param g
     */
    public DegreeBFS(Graph g) {
        this.g = g;
    }
    
    /**
     * Return the degree between u and v on the graph g.
     * 
     * @param u
     * @param v
     * @return
     */
    public int degree(int u, int v) {
        int degree = -1;

        q = new ArrayDeque<Node>();
        marked = new boolean[g.n()];
        q.addLast(new Node(u, 0));
        
        while(!q.isEmpty()) {
            Node n = q.pollFirst();
            
            if(n.index == v) {
                // Found v
                degree = n.degree;
                break;
            }
            
            if(!marked[n.index]) {
                addNeighbours(n);
                marked[n.index] = true;
            }
        }
        
        return degree;
    }

    private void addNeighbours(Node n) {
        for(Edge e: g.adj(n.index)) {
            int otherVertex = e.other(n.index);
            q.addLast(new Node(otherVertex, n.degree + 1));
        }
    }

    private class Node {
        int index;
        int degree;
        
        Node(int index, int degree) {
            this.index = index;
            this.degree = degree;
        }
    }

}
