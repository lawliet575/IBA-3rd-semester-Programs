public class Graph {
     vertex[] graph; //adjacencylist array of arraylist
    int count;// + when add - when subtract
    //count is my index

    Graph(int s){
        graph=new vertex[s+s/3];
        count=0; 

        for (int i = 0; i < graph.length; i++) {
            graph[i]=new vertex(null, 0);    
        }
    }


    public void Addvertex(String n,int a){//array me directly add
        //insert at count position as size is count+1
        if(count==graph.length-1){
            System.out.println("GRAPH FULL");
            return;
        }
        vertex temp=new vertex(n, a);//make vertex
        graph[count]=temp;//add at count index
        count++;
    }

    public void AddEdge(String n1,String n2){//n1 and n2 will aready exist
        int v1=-1;
        int v2=-1;

        for (int i = 0; i <count; i++) {
            if(graph[i].name.compareToIgnoreCase(n1)==0){
                v1=i;
            }
            else if(graph[i].name.compareToIgnoreCase(n2)==0){
                v2=i;
            }
            
        }

        if(v1!=-1 && v2!=-1){
            graph[v1].friendslist.insert(graph[v2]);
            graph[v2].friendslist.insert(graph[v1]);
        }

    }


    public vertex Findvertex(String n){//directly from array
        for (int i = 0; i <count; i++) {
            vertex temp=graph[i];

            if(temp.name.compareToIgnoreCase(n)==0){
                return temp;
            }
        }
        return null;
    }

    public void deletevertex(String n){
        int dindx=-1;
        vertex dvertex=null;
        for (int i = 0; i <count; i++) {
            vertex temp=graph[i];
            if(temp.name.compareToIgnoreCase(n)==0){
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
            vertex temp=graph[i];
            temp.friendslist.delete(dvertex);
        }


        
    }


    public void deleteEdge(String n1,String n2){
        vertex v1=Findvertex(n1);
        vertex v2=Findvertex(n2);

        if(v1==null || v2==null){
            System.out.println("NOT FOUND");
            return;
        }

        v1.friendslist.delete(v2);//A-->B# C D
        v2.friendslist.delete(v1);//B-->A# F G hashtags deleted
    }


    public String toString(){
        String str="";
    for (int i = 0; i <=count; i++) {
        vertex temp=graph[i];
        str+=temp.toString()+" neighbours--> ";//we get name and age till here
       LinkedList<vertex> ll=temp.friendslist;
       str+=ll.toString()+"\n";
    }
    return str;
    }



    
}
