import java.util.Stack;

public class Graph<T extends Comparable<T>> {
     vertex<T>[] graph; //adjacencylist array of arraylist
     int count;// + when add - when subtract
    //count is my index

    Graph(int s){
        graph=new vertex[s+s/3];
        count=0; 

        for (int i = 0; i < graph.length; i++) {
            graph[i]= new vertex(null, -1);    
        }
    }


    public void Addvertex(T n){//array me directly add
        //insert at count position as size is count+1
        if(count==graph.length-1){
            System.out.println("GRAPH FULL");
            return;
        }
        vertex<T> temp=new vertex<T>(n, count);//make vertex
        graph[count]=temp;//add at count index
        count++;
    }

    public void AddEdge(T n1,T n2){//n1 and n2 will aready exist
        int v1=-1;
        int v2=-1;

        for (int i = 0; i <count; i++) {
            if(graph[i].data.compareTo(n1)==0){
                v1=i;
            }
            else if(graph[i].data.compareTo(n2)==0){
                v2=i;
            }
            
        }

        if(v1!=-1 && v2!=-1){
            graph[v1].neighbours.insert(graph[v2]);
            graph[v2].neighbours.insert(graph[v1]);
        }

    }


    public vertex<T> Findvertex(T n){//directly from array
        for (int i = 0; i <count; i++) {
            vertex<T> temp=graph[i];

            if(temp.data.compareTo(n)==0){
                return temp;
            }
        }
        return null;
    }

    public void deletevertex(T n){
        int dindx=-1;
        vertex<T> dvertex=null;
        for (int i = 0; i <count; i++) {
            vertex<T> temp=graph[i];
            if(temp.data.compareTo(n)==0){
                dvertex=graph[i];
                dindx=i;//deleted index
                graph[i]=null;//deletion
            }
        }

        if(dindx==count){//count is last present value in graph us se aage obv null
            count--;
            return;
       }

        //now if dindx at start or somewhere at between
        for (int i = dindx; i <count; i++) {
            graph[dindx]=graph[dindx+1];//shift all elements backwards
        }
        count--;


      //deleting from neighbours as well
        for (int i = 0; i <count; i++) {
            vertex<T> temp=graph[i];
            temp.neighbours.delete(dvertex);
        }


        
    }


    public void deleteEdge(T n1,T n2){
        vertex<T> v1=Findvertex(n1);
        vertex<T> v2=Findvertex(n2);

        if(v1==null || v2==null){
            System.out.println("NOT FOUND");
            return;
        }

        v1.neighbours.delete(v2);//A-->B# C D
        v2.neighbours.delete(v1);//B-->A# F G hashtags deleted
    }


    public String toString(){
        String str="";
    for (int i = 0; i <count; i++) {
        vertex<T> temp=graph[i];
        str+=temp.toString()+" neighbours--> ";//we get name and age till here
       LinkedList<vertex<T> > ll=temp.neighbours;
       str+=ll.toString()+"\n";
    }
    return str;
    }

    public void DFS(vertex<T> ver){
        Stack<vertex<T> > s=new Stack<>();
        //peek
        s.push(ver);
        ver.setvisited(true);
        System.out.println(ver+" ");

        while(!s.isEmpty()){
            vertex<T> v=s.peek();
            //push neighbour of v in stack
            vertex<T> w=v.getunvisitedneighbour();
            
            if(w != null && !w.isvisited()){ //safety check 2nd
                s.push(w);//pushed w
                w.setvisited(true);//marked w as visited
                System.out.println("vertex: " + w.data + " edge: " + v.data+" "+w.data+" ");
            }
            else{
                s.pop();
            }

        }
    }

    
    public void BFS(vertex<T> ver){
        Queue<vertex<T>> q=new Queue<>();
        q.Enqueue(ver);
        ver.setvisited(true);
        System.out.println(ver.data);

        while(!q.isEmpty()){
            vertex<T> temp=q.Dequeue();

            //add temp ke all neighbours to queue
            for (int i = 0; i < temp.neighbours.size; i++) {
               vertex<T> w=temp.neighbours.get(i);
               if(w!=null && !w.visited){
                q.equals(w);
                w.setvisited(false);
                System.out.println("vertex: " + w.data + " edge: " + ver.data+" "+w.data+" ");
               }
                
            }
        } 
    }         
    

        
     public void shortestPath(T d1, T d2) {
    vertex<T> src = Findvertex(d1);
    vertex<T> to = Findvertex(d2);

    Queue<vertex<T>> q = new Queue<>();
    q.Enqueue(src);
    src.shortestPath.insert(src);
    src.setvisited(true);

    System.out.println("Source: " + src);
    System.out.println("Destination: " + to);

    while (!q.isEmpty()) {
        vertex<T> v = q.Dequeue();

        for (int i = 0; i < v.neighbours.size; i++) {
            vertex<T> w = v.neighbours.get(i); //  Access the neighbors of v

            if (w != null && !w.isvisited()) {
                q.Enqueue(w); //  Enqueue w instead of q.equals(w)
                w.setvisited(true); //  Set visited to true
                w.shortestPath.insert(w);

                // Copy the shortest path from v to w
                for (int j = 0; j < v.shortestPath.size; j++) {
                    w.shortestPath.insert(v.shortestPath.get(j));
                }
            }
        }
    }

    // Print the shortest path
    /* 
    System.out.print("Shortest Path: ");
    for (int i = 0; i < to.shortestPath.size; i++) {
        System.out.print(to.shortestPath.get(i).data + " ");
    }
    System.out.println();
    */

    System.out.print("Shortest Path: ");
    for (int i = to.shortestPath.size-1; i >=0; i--) {
        System.out.print(to.shortestPath.get(i).data + " ");
    }
    System.out.println();


    
}


    

    







    
}
