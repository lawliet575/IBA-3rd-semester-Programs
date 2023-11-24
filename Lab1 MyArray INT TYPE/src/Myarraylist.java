
public class Myarraylist{
        static int[] arr;
        static int currIndex;

        Myarraylist(){ //empty constr to create 10                                                                                                                           size array
            arr=new int[10];
            currIndex=-1;
        }

        Myarraylist(int size) { // constructor to create an array
            arr = new int[size];
            currIndex=-1;
        }

        public void PrintList(){

            System.out.print("{ ");

            for(int i=0; i<arr.length;i++){
                System.out.print(arr[i]+ " ");
            }
            System.out.println(" }");
        }

        public void InsertInOrder(int v) {
            if (currIndex == arr.length - 1) { 
                int[] newArr = new int[arr.length * 2]; 
                for (int i = 0; i <= currIndex; i++) {
                    newArr[i] = arr[i]; 
                }
                arr=newArr; //ref copy 
                currIndex++;
               arr[currIndex]=v;
            }
    
            if (currIndex == -1) {
                currIndex++;
                arr[currIndex] = v; 
                
            } else {
                int i = currIndex;
                while (i >= 0 && arr[i] > v) {
                    arr[i + 1] = arr[i]; 
                    i--;
                }

                arr[i + 1] = v; 
                currIndex++;
            }
        }

        public int Length() {
            return currIndex+1;
        }

        public int get(int index) { //sorted list ka index vala element dega
            if(index>currIndex){
                System.out.println("Invalid Index");
                return -1;
            }

            return arr[index];
        }

        public void Update (int index, int value) {
            if(index>currIndex){
                System.out.println("Invalid Index");
                return ;
            }

            arr[index]=value;
            return;
        }

        public int Find (int value) { //return index of value
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==value){
                    //System.out.println("Value at index");
                    return i;
                }
            }
            System.out.println("Not found");
            return -1;
        }


        public void Remove (int value) {
            int temp=Find(value);//temp  me index hai
            if(temp==-1){
                return;
            }

            //find krli hai index ab bas replacement removing shru kro
            for (int i = temp; i <currIndex+1; i++) {
                 arr[i]=arr[i+1];
                }
                currIndex--; //remove hone ke baad decrement currindex
                

            }

        }

    

