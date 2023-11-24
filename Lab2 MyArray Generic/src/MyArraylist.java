
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

    public String toString(){
        String str="";
        for(int i=0; i<arr.length;i++)
            str=str+arr[i]+ "\n";
        return str;
    }

    public void PrintList(){

        System.out.print("{ ");

        for(int i=0; i<arr.length;i++){
            System.out.print(arr[i]+ " ");
        }
        System.out.println(" }");
    }

    public void Add(T data){ //addition in last
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
            int i = currIndex;
            arr[currIndex+1]=data;
            currIndex++;
        }
    }

    /*
    public void InsertInOrder(int v) {
        if (currIndex == arr.length - 1) { //full array
            int[] newArr = new int[arr.length * 2];
            for (int i = 0; i <= currIndex; i++) {
                newArr[i] = arr[i];
            }
            arr = newArr;
        }

        if (currIndex == -1) { //empty array
            currIndex++;
            arr[currIndex] = v;
        }

        else { half filled array
            int i = currIndex;
            while (i >= 0 && arr[i] > v) {
                arr[i + 1] = arr[i];
                i--;
            }
            arr[i + 1] = v;
            currIndex++;
        }
    }
     */

    public int Length() {
        return currIndex+1;
    }

    public T get(int index) { //sorted list ka index vala element dega
        if(index>currIndex){
            System.out.println("Invalid Index");
            return null;
        }

        T data=arr[index];
        return data;
    }

    public void Update (int index, T data) {
        if(index>currIndex){
            System.out.println("Invalid Index");
            return ;
        }
        arr[index]=data;
        return;
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

    public int FindMax(){
     int maxindex=0;
        for (int i = 1; i <=currIndex; i++) {
            int temp=arr[maxindex].compareTo(arr[i]);//
            if(temp==1){
                maxindex=i;
            }
            else continue;
        }
        System.out.println("Index of student with best CPGA");
        return maxindex;
    }


    public void Remove (T value) {
        int Searchedidx=Find(value);//Searchedidx  me index hai
        if(Searchedidx==-1){
            return;
        }

        if(Searchedidx==arr.length-1){//last element ko remove krna hai
           arr[Searchedidx]=null;
        }

        //find krli hai index ab bas replacement removing shru kro
        for (int i = Searchedidx; i <currIndex+1; i++) {
            arr[i]=arr[i+1]; //move one one forwards
        }
        currIndex--; //remove hone ke baad decrement currindex
    }

    public void clear(){
        int currsize=arr.length;
        arr = (T[]) new Comparable[currsize];
        currIndex=-1;
    }



}



