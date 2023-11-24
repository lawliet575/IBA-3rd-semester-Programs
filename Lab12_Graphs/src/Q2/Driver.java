package Q2;

public class Driver {
    public static void main(String[] args) {
        GraphAdjMatrix gm=new GraphAdjMatrix(4);
        gm.addvertex("A");
        gm.addvertex("B");
        gm.addvertex("C");
        gm.addvertex("D");

        gm.addEdge("A", "B");
        gm.addEdge("A", "C");


        gm.display();
    }
    
}
