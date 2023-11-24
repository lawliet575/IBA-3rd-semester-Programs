package Q1;

import java.util.stream.IntStream;

public class Driver {
    public static void main(String[] args) {
        int[] arr=IntStream.rangeClosed(-98, 130).toArray();
        
        //FOR PART(a)
        System.out.println("There are "+ arr.length+" elements in the array");
        //FOR PART(e)
        System.out.println("arr[120]= "+ arr[120]);
    }
}
