package degree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Graph representation.
 * 
 * @author anoopelias
 * 
 */
public class Graph {

    private int n;

    private List<Set<Edge>> adjacencyList;

    public Graph(int n) {
        this.n = n;
        init();
    }

    private void init() {
        adjacencyList = new ArrayList<Set<Edge>>();
        for(int i=0; i<this.n; i++) {
            adjacencyList.add(new HashSet<Edge>());
        }
    }

    public Graph(InputStream is) throws NumberFormatException, IOException {

        BufferedReader reader = null;
        try {

            reader = new BufferedReader(new InputStreamReader(is));
            this.n = Integer.parseInt(reader.readLine());
            init();
            
            int c = Integer.parseInt(reader.readLine());
            for (int i = 0; i < c; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                addEdge(new Edge(from, to));
            }

        } finally {
            if (reader != null)
                reader.close();
        }

    }
    
    public int n() {
        return n;
    }

    public Set<Edge> adj(int v) {
        return adjacencyList.get(v);
    }
    
    public Set<Edge> edges() {
        Set<Edge> allEdges = new HashSet<Edge>();
        for(Set<Edge> s : adjacencyList)
            allEdges.addAll(s);
        
        return allEdges;
    }

    public boolean addEdge(Edge e) {
        int from = e.either();
        int to = e.other(from);
        
        adjacencyList.get(from).add(e);
        return adjacencyList.get(to).add(e);
    }

    public void print() {
        System.out.println(n);
        Set<Edge> edges = edges();
        System.out.println(edges.size());
        for (Edge e : edges) {
            System.out.println(e.either() + " " + e.other(e.either()));
        }
    }
    

}
