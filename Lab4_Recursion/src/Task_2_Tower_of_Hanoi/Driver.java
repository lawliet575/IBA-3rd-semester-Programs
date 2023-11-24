package Task_2_Tower_of_Hanoi;


public class Driver {

    public static void towerofhanoi(int n,String src,String help,String dest){

        if(n==1){//BASE CASE
            System.out.println("Move "+n+" Disk "+" from "+src+" to "+dest);
            return;

        }

        towerofhanoi(n-1,src,dest,help);//n-1 moved to helper using dest as helper
        System.out.println("Move disk "+n+" from "+src+" to "+dest);//moving 1 remaining diske from 1 to 3
        towerofhanoi(n-1,help,src,dest);

    }



    public static void main(String[] args) {
        int n=5;  //NUMBER OF DISKS
        towerofhanoi(n,"S","H","D");

    }
}
