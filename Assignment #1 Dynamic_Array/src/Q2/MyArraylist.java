package Q2;


public class MyArraylist< T extends Comparable<T> > {
     T[] arr;
     int currIndex;

    MyArraylist(){ //empty constructor to create 10 for first time                                                                                                                          size array
        arr = (T[])new Comparable[10];
        currIndex=-1;
    }

    MyArraylist(int size) { // constructor to create an array
        arr = (T[]) new Comparable[size];
        currIndex=-1;
    }

    public Boolean isEmpty(){
        if(currIndex==-1){
            return true;
        }
        return false;
    }

    public String toString(){
        String str="";
        for(int i=0; i<arr.length;i++)
            str=str+arr[i]+ "\n";
        return str;
    }

    public void Print(){
        if(currIndex==-1){
            System.out.println("Empty array");
            return;
        }

        System.out.print("{ ");

        for(int i=0; i<=currIndex;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println("}");
    }


    public void addAtEnd(T data){ //addition in last
        if(currIndex==-1){ //empty array
            currIndex++;
            arr[currIndex]=data;
        }
        else if (currIndex == arr.length - 1) { //full array
            T[] newArr = (T[]) new Comparable[arr.length * 2];
            for (int i = 0; i <= currIndex; i++) {
                newArr[i] = arr[i];//old copy to new
            }
            arr=newArr; //ref copy 
             currIndex++;
            arr[currIndex]=data;
           
        }

        else { //half filled array
            currIndex++;
            arr[currIndex]=data;
        }
    }

    public void addAtFront(T value){
        if(currIndex==-1){ //Empty list
        currIndex++;
        arr[currIndex]=value;
        }

        if(currIndex==arr.length-1){ //full list
         T[] newArr = (T[]) new Comparable[arr.length * 2];  
         for (int i = 0; i <=currIndex; i++) {
           newArr[i+1]=arr[i]; //ese 1st element of new array is now empty
          }
          arr=newArr;
          arr[0]=value;
        }


        else{//half filled array
        for (int i = currIndex; i>=0; i--) {
            arr[i+1]=arr[i]; //this moves each element one one forwards  
        }
        arr[0]=value;
        currIndex++;//goes to last value now as 1st pe add hogyi

        }

    }


    public void sort(){
        if(currIndex==-1){
            System.out.println("EMPTY list");
            return;
        }

        for (int i = 1; i <=currIndex; i++) {
            T current=arr[i];
            int j=i-1;
            while(j>=0 &&  (current.compareTo(arr[j])==-1 ) ){
             arr[j+1]=arr[j];
             j--;
            }

            arr[j+1]=current;
            
        }

    }


    public int Find (T data) { //return index of value
          for (int i = 0; i < arr.length; i++) {
            if(arr[i]==data){
                System.out.println("Value at index");
                return i;
            }
          } 

        System.out.println("Not found");
        return -1;  
    }



    public void reverse(){
        if(currIndex==-1){
            System.out.println("Empty array");
            return;
        }

        int first=0;
        int last=currIndex;

        while( first<last ){ //similar to reversing in arrays
          T temp=arr[last];
          arr[last]=arr[first];
          arr[first]=temp;

          first++;
          last--;
        }

    }


    public void removeFirst(T value){
        int index=-1;

        for(int i=currIndex;i>=0;i--){
            if( arr[i]==value ){
                index=i;
            }
            if(index!=-1)
            break;

        }
        if(index==-1){ //empty list
            System.out.println("Element not found");
            return;
        }

        if(index==arr.length-1){ //end vala element remove hoga
         arr[currIndex]=null;
         currIndex--;   

        }


        //INDEX FOUND OF FIRST OCCURANCE BY BACKWARD MOVEMENT
        //NOW REMOVING
        for (int i = index; i <=currIndex; i++) {
            arr[i]=arr[i+1];//1 1 piche krdye element
        }
        currIndex--;

    }


    public void removeAll(T value){
        for (int i =currIndex; i>=0; i--) {
            if(arr[i]==value){
                removeFirst(arr[i]);
            }
        }

    }

    public int Length() {
        if(currIndex==-1){
            return 0;
        }
        return currIndex+1;
    }


}



