public class Driver {
    public static void main(String[] args) {
        Graph g=new Graph(4);
        g.Addvertex("Ikhlas", 20);
        g.Addvertex("Atiq", 15);
        g.Addvertex("Saad", 25);
        g.Addvertex("messi", 30);

        g.AddEdge("Ikhlas", "Atiq");
        g.AddEdge("Ikhlas", "Saad");
        g.AddEdge("Saad", "messi");

       //vertex v=g.Findvertex("rasheed");
       //System.out.println(v);

       
       //System.out.println(g);
       //g.deletevertex("Ikhlas");
       //System.out.println(g);

       //System.out.println(g);
       //g.deleteEdge("ikhlas", "saad");
       //System.out.println(g);


    }
    
}
