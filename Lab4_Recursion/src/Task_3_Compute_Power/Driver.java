package Task_3_Compute_Power;

public class Driver {

    public static int power(int base,int powerR){
        if(powerR==1){
            return base;
        }

        return power(base,powerR-1) * base;


    }


    public static void main(String[] args) {
        System.out.println(power(2,5));
    }


}
