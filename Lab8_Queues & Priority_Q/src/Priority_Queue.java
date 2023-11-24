public class Priority_Queue < T extends Comparable<T> > { //ASCENDING 2,4,6,8,10
    T[] arr;
    int p; //pointer 

    Priority_Queue(){
        arr=(T[]) new Comparable[10];
        p=-1;
    }

    Priority_Queue(int size){
        arr=(T[]) new Comparable[size];
        p=-1;
    }

    public boolean isEmpty(){
        if(p==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
      if(p==arr.length-1) {
          return true;
      }
      return false;
    }

    public String toString(){
        String temp="";
        for (int i = 0; i <arr.length; i++) {
            temp+=arr[i]+" ";
        }
        return temp;
    }

    public  void Enqueue(T data){
        if(isFull()) {
            return;
        }

        if(isEmpty()){
            p++;
            arr[p]=data;
            return;
        }

        if(data.compareTo(arr[p])>=0){ //ane vala data larger or queue empty 
            p++;
            arr[p]=data;
            return;
        }

        if(data.compareTo(arr[p])<0 ){ //ane vala data smaller so vo smaller ke baad he add hoga FIFO
            //FIND A NUMBER WHICH IS SMALLER THAN THE DATA
            int x=-1;
            for (int i = p; i >=0; i--) {
                if(arr[i].compareTo(data)<0) {
                    x = i;
                    break;
                }
            }

             int i=p;
             while(i>=x+1){ //shifting elements forward after smallest found till last element(p) to make space for new data 4 6 7 8 --> 4 __ 6 7 8
                 arr[i+1]=arr[i];
                 i--;
             }

            x++;
             arr[x]=data;//inserted at correct order
            p++;
        }

    }

    public T Dequeue(){
        if(isEmpty()){
            return null;
        }

        T data=arr[0];
        int i=0;
        while(i<p){
            arr[i]=arr[i+1];//shift backwards to replace first element
            i++;
        }
        arr[p]=null;//remove end wala 
        p--;
        return data;
    }

    public T peek(){
        if(isEmpty()){
            return null;
        }
        return  arr[0];
    }










}



