package Task_1_Max_int_rec;

public class Main {

    public static void findmax(int[] arr,int n,int max,int calls){

        if(n==arr.length){ //BASE CASE
            System.out.println("Maximum integer= "+max);
            System.out.println("Number of recursive calls= "+calls);//
            return;
        }


        if(arr[n]>max){
            max=arr[n];
        }
        findmax(arr,n+1,max,calls+1);

    }


    public static void main(String[] args) {
        int[] arr={32,54,76,106,34,76,96};
        findmax(arr,0,0,0);


    }
}
