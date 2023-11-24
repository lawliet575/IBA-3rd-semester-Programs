package Q3;


public class Driver {
 
      static int count=0;

    public static void towerofhanoi(int n,char src,char help,char dest){
     
        if(n==1){//BASE CASE
            System.out.println("Move "+n+" Disk "+" from "+src+" to "+dest);
            return;

        }
 
        count++; //for 1st recursion
        towerofhanoi(n-1,src,dest,help);//n-1 moved to helper using dest as helper
        System.out.println("Move disk "+n+" from "+src+" to "+dest);//moving 1 remaining diske from 1 to 3
        count++;
        towerofhanoi(n-1,help,src,dest);

    }



    public static void main(String[] args) {
        int n=4;  //NUMBER OF DISKS
        towerofhanoi(n,'S','H','D');
        System.out.println(count +" Recursive Calls");
       
    }
}


