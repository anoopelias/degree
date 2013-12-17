package degree;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;

public class DegreeBFSTest {
    
    @Test
    public void test_degree() throws NumberFormatException, IOException {
        Graph g = new Graph(this.getClass().getClassLoader().getResourceAsStream("10x20.txt"));
        DegreeBFS d = new DegreeBFS(g);
        assertEquals(0, d.degree(6, 6));
        assertEquals(1, d.degree(6, 7));
        assertEquals(2, d.degree(0, 7));
        assertEquals(3, d.degree(1, 2));
    }
    
    @Test
    public void test_degree_large() throws NumberFormatException, IOException {
        Graph g = new Graph(this.getClass().getClassLoader().getResourceAsStream("5000x3000.txt"));
        DegreeBFS d = new DegreeBFS(g);
        long time = System.nanoTime();
        assertEquals(3, d.degree(3738, 813));
        System.out.println(System.nanoTime() - time + " nSecs");
    }

    @Test
    public void test_degree_larger() throws NumberFormatException, IOException {
        Graph g = new Graph(this.getClass().getClassLoader().getResourceAsStream("5000x10000.txt"));
        DegreeBFS d = new DegreeBFS(g);
        
        long time = System.nanoTime();
        assertEquals(7, d.degree(2500, 200));
        System.out.println(System.nanoTime() - time + " nSecs");
        
    }

    @Test
    public void test_degree_largest() throws NumberFormatException, IOException {
        Graph g = new Graph(this.getClass().getClassLoader().getResourceAsStream("5000x30000.txt"));
        DegreeBFS d = new DegreeBFS(g);
        
        long time = System.nanoTime();
        assertEquals(4, d.degree(4500, 1000));
        System.out.println(System.nanoTime() - time + " nSecs");
        
    }

}
