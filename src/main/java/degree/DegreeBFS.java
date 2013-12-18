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
        q = new ArrayDeque<Node>();
        marked = new boolean[g.n()];
        q.addLast(new Node(u, 0));

        while (!q.isEmpty()) {
            Node n = q.pollFirst();

            if (n.index == v)
                return n.degree;

            if (!marked[n.index]) {

                for (Edge e : g.adj(n.index))
                    q.addLast(new Node(e.other(n.index), n.degree + 1));

                marked[n.index] = true;
            }
        }

        return -1;
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
