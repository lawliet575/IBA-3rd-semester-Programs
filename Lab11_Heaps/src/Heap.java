public class Heap<T extends Comparable<T>> {
    T[] arr;
    int size;

    Heap(int s){
        size=0;
        arr=(T[]) new Comparable[s];
    }

    public T getMax(){
        return arr[0];
    }

    public void insert(T val){
        if(size==arr.length){
            System.out.println("HEAP FULL");
            return;
        }

      //now call sift up from index to be inserted=size
      arr[size]=val;
      siftup(size);
      size++;

    }

    public void siftup(int index){
        if(index==0){
            return;
        }
        T temp=arr[index]; //child
        int parent=(index-1)/2; //parent
        //SWAPPING
        if(arr[index].compareTo(arr[parent])>0){ //jab tak child bara hai parent se tab tak chale//ya child equalna ho root ke
        arr[index]=arr[parent];
        arr[parent]=temp;
        siftup(parent);
        }
        //now parent has the newly inserted value which has moved upwardds
        //call again that index to be sift up again
        
        

    }


    public T extractMax(){//isme size-- hoga
        //note leaf node is my size -1
        //means last level kee right most value 

        T finalans=getMax();
        arr[0]=arr[size-1];//size -1 is my leaf node it becomes the max node now
        arr[size-1]=null;//removed leaf now
        size--;
        //currently now heap ke top par min value hai
        //so call sift down
        siftdown(0);
        return finalans;

    }

    public void siftdown(int index){
        if(arr[index]==null){ //reached last level
            return;
        }


        int left=(2*index)+1;
        int right=(2*index)+2;

        if(left<size && right<size){//means left and right will never be null

            if(arr[right].compareTo(arr[index])>0){//right>index
            //swap right and index
            T temp=arr[index];
            arr[index]=arr[right];
            arr[right]=temp;
            siftdown(right);//now value at right so sift down called here again
        }

        else if(arr[left].compareTo(arr[index])>0){
            //swap left and index
            T temp=arr[index];
            arr[index]=arr[left];
            arr[left]=temp;
            siftdown(left);
        }

        }
        

    }

    public void printheap(){
        for (int i = 0; i <arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public int find(T val){//return index of finded value
        for (int i = 0; i <arr.length; i++) {
            if(arr[i].compareTo(val)==0)
            return i;
        }

        return -1;//in case not found
    }

    public void update(T old,T n){//change old t v
        int index=find(old);
        if(index==-1){
            System.out.println("NOT Found");
            return;
        }

        arr[index]=n;//update val

    
    if(n.compareTo(old)>0){
        siftup(index);
    }
    else{//n.compareTo(old)<0
        siftdown(index);
    }

//can do this as well where parent se compare horha directly
         /* 
        
        
        if(index==0){
            return;
        }

        int parent=(index-1)/2;

        if(arr[index].compareTo(arr[parent])>0){
            siftup(index);
        }
        else if(arr[index].compareTo(arr[parent])<0){
            siftdown(index);
        }
        */

    }


    public void remove(T value){
        //note leaf node is my size -1
        //means last level kee right most value 
        int index=find(value);
        if(index==-1){
        System.out.println("Not found");
        return;
        }

        arr[index]=arr[size-1];//remove wala replaced by leaf
        arr[size-1]=null;//leaf set to null
        size--;

        if(index==0){
            return;
        }

        int parent=(index-1)/2;

        if(arr[index].compareTo(arr[parent])>0){
            siftup(index);
        }
        else if(arr[index].compareTo(arr[parent])<0){
            siftdown(index);
        }
    }






    


    
}
