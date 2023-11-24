package Q2;

public class GraphAdjMatrix {

    vertex vertexlist[];//array of vertices
    int vertexcount;//vertex index in vertexlist
    int adjmat[][];

    GraphAdjMatrix(int s){
        vertexlist=new vertex[s];
        vertexcount=0;
        adjmat=new int[s][s];
    }


    public void addvertex(String L){
        if(vertexcount==vertexlist.length){
            return;//cannot add 
        }
        vertex temp=new vertex(L, vertexcount);
        vertexlist[vertexcount]=temp;
        vertexcount++;
    }

    public void addEdge(String l1,String l2){
        if(l1.compareToIgnoreCase(l2)==0){
            return;//same connections nahi hoskte
        }

        int first=-1;
        int second=-1;

        for (int i = 0; i <vertexcount; i++) {
            vertex temp=vertexlist[i];
            if(temp.label.compareToIgnoreCase(l1)==0){
                first=temp.num;
            }
            else if(temp.label.compareToIgnoreCase(l2)==0){
                second=temp.num;
            }
        }

       //now i have indexes of both edges
        if(first!=-1 & second!=-1){
        adjmat[first][second]=1;
        adjmat[second][first]=1;
        }

    }

    public void display2(){
        //row printing
  for (int i = 0; i < vertexlist.length; i++) {
    if(i == 0){
      for (int j = 0; j < adjmat.length; j++) {
        System.out.print(vertexlist[j].label+" ");
      }
      System.out.println();
    }
    for (int j = 0; j < adjmat[i].length; j++) {
      System.out.print(adjmat[i][j]+" ");
    }
    System.out.println();
  }
}
    

   public void display(){


   //row printing
   System.out.print("   ");
    for (int i = 0; i <vertexlist.length; i++) {
        System.out.print(vertexlist[i].label+" ");
    }
    System.out.println();

   //  coloumn printing inside
        for (int i = 0; i < adjmat.length; i++) {

            for (int j = 0; j < adjmat[i].length; j++) {
                if(j==0){
                    System.out.print(vertexlist[i].label+"  ");
                }

                System.out.print(adjmat[i][j]+" ");
            }
            System.out.println();
            
        }
    }
    
}
