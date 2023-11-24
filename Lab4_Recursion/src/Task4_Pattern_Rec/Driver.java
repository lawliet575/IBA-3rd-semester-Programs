package Task4_Pattern_Rec;

public class Driver {

    public static void Pattern(int n){

        if(n==0){
         return;
        }


        for (int i = n; i >0 ; i--) { //DECREASING PATTERN
            System.out.print("*");
        }
        System.out.println();
        Pattern(n-1);

        for (int i = 1; i<=n ;i++) { //DECREASING PATTERN
            System.out.print("*");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        Pattern(5);





    }
}
