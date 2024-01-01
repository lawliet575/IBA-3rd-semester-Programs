public class Driver {
    public static void main(String[] args) {
        Graph<Integer> g=new Graph<Integer>(4);
        g.Addvertex(0);
        g.Addvertex(1);
        g.Addvertex(2);
        g.Addvertex(3);


        g.AddEdge(0, 1);
        g.AddEdge(0, 2);
        g.AddEdge(1, 2);
        g.AddEdge(2, 3);
        

       //System.out.println(g);

       //g.DFS(g.Findvertex(2));
       //g.BFS(g.Findvertex(2));
       g.shortestPath(0, 3);



    }
    
}
