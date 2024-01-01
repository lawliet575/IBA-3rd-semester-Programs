
public class vertex<T> {
    T data;
    int v_idx;//vertex index ke wo konse index pr hai in the array
    LinkedList< vertex<T> > neighbours=new LinkedList< vertex<T> >();
    boolean visited;

    //for shortest distance
    LinkedList<vertex<T>> shortestPath=new LinkedList<>();

    vertex(T na,int n){
     data=na;
     v_idx=n;
     visited=false;
    }

    public vertex<T> getunvisitedneighbour(){
      Node<vertex<T>> current=neighbours.gethead();
      while(current!=null){
        if(!current.data.visited){
          return current.data;
        }
        current = current.next;
      }
      return null;
      
    }

    public void setvisited(boolean b){
      visited=b;
    }

    public boolean isvisited(){
      return visited;
    }

    public String toString(){
      String str="";
      str+=data;
      return str;
    }

    
}
