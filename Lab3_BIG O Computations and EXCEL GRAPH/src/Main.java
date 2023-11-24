import java.util.stream.IntStream;

public class Main {

    public static int LinearSearch(int[] arr,int n,int num){ //
  int comparisions=0;

        for (int i = 0; i < n; i++) {
            comparisions++;
            if(arr[i]==num) {
                System.out.println("Comparisions in Linear= " + comparisions);
                return i;
            }
        }
        return -1;
    }

    public static int BinarySearch(int[] arr,int n,int num){
        int comparisions=0;

            int first = 0;
            int last = n - 1;
            int mid = (first + last) / 2;
            while (first < last) {
                comparisions++;

                if (arr[mid] > num)
                    last = mid - 1;
                else if(arr[mid]==num) {
                    System.out.println("Comparisions in Binary= " + comparisions);
                    return mid;
                }
                else
                    first = mid + 1;
                mid = (first + last) / 2;
            }
            if (arr[mid] == num) {
                System.out.println("Comparisions in Binary= " + comparisions);
                return mid;
            }
            else {
                System.out.println("Comparisions in Binary= " + comparisions);
                return -1;
            }
    }

    public static int BinarySearchforprob2(int[] arr,int n,int num){
        int comparisions=0;

        int first = 0;
        int last = n - 1;
        int mid = (first + last) / 2;
        while (first < last) {
            comparisions++;

            if (arr[mid] > num)
                last = mid - 1;
            else if(arr[mid]==num) {
                //System.out.println("Comparisions in Binary= " + comparisions);
                return comparisions;
            }
            else
                first = mid + 1;
            mid = (first + last) / 2;
        }
        if (arr[mid] == num) {
            //System.out.println("Comparisions in Binary= " + comparisions);
            return comparisions;
        }
        else {
            //System.out.println("Comparisions in Binary= " + comparisions);
            return -1;
        }
    }

    public static void myfunc(int[] arr,int n){ //for problem 2

        int count=0;//counts for primitive operations

        //for n^3 dominant
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    count++;
                }
            }
        }
        System.out.println("Number of computations for dominant term n^3= "+count);


        //for n single
        for (int i = 0; i < n; i++) {
            count++;//add count as it is for single N
        }
        //System.out.println("Number of computations for n= "+count);

        //for nlogn
        for (int i = 0; i < n; i++) {
            count+=BinarySearchforprob2(arr,n,0); //add counts of binarytest as binarytest is O(nlogn)
        }

        System.out.println("Total Computations T(N)= "+count);

    }

    public static void main(String[] args) {




        //FOR TASK 1 (I recommend aik task aik waqt pr chalaye please and dusra comment kre )
        /*
        int N=10000; //can take input here as well
        int[] arr=IntStream.range(0,N).toArray();
     //LINEAR SEARCH
     long startL=System.nanoTime();
     int Linear_index= LinearSearch(arr,arr.length,7500);
     long endL=System.nanoTime();
     if(Linear_index!=-1){
         System.out.println("Index from Linear search= "+Linear_index);
         System.out.println("Time for Linear Search "+ (endL-startL)+" Nano-Seconds");
     }
     else {
         System.out.println("NOT FOUND");
     }

     //BINARY SEARCH
        long startB=System.nanoTime();
        int Binary_index= BinarySearch(arr,arr.length,7500);
        long endB=System.nanoTime();
        if(Binary_index!=-1){
            System.out.println("Index from Binary search= "+Binary_index);
            System.out.println("Time for Binary Search "+ (endB-startB)+" Nano-Seconds");
        }
        else {
            System.out.println("NOT FOUND");
        }

       */

        //TASK 2

        int N2=10; //can take input here as well
        int[] arr2;
        for (int i = N2; i <1001 ; i++) {
            System.out.println("No.= "+ i);
            arr2=IntStream.range(0,i).toArray();
            myfunc(arr2,i);
            System.out.println();
        }


        //forprob2
        //myfunc(arr,N); dont uncomment just for referance hai ye


    }







}
