package Q4;

public class Driver {
    public static void main(String[] args) {
        TwoDimensionalDynamicArray twoarray=new TwoDimensionalDynamicArray(3, 3);
        twoarray.print2d();
        System.out.println();


        int[] randcol=new int[3];
        for (int i = 0; i < randcol.length; i++) {
            randcol[i]= (int)(Math.random()*10);
        }
        twoarray.appendCol(randcol);
        twoarray.appendCol(randcol);
        twoarray.appendCol(randcol);
        twoarray.appendCol(randcol);
        twoarray.appendCol(randcol);
        twoarray.print2d();

        System.out.println();


         int[] randrow=new int[5];
        for (int i = 0; i < randrow.length; i++) {
            randrow[i]= (int)(Math.random()*10);
        }
         twoarray.appendRow(randrow);
         twoarray.appendRow(randrow);
         twoarray.appendRow(randrow);
         twoarray.appendRow(randrow);
         twoarray.appendRow(randrow);
         twoarray.appendRow(randrow);
         twoarray.print2d();


        
        //TEST CASE ACCORDING IN THE WORD FILE
         /* 
        TwoDimensionalDynamicArray testarr=new TwoDimensionalDynamicArray(2, 2);
        System.out.println();
        testarr.print2d();
        testarr.appendCol(new int[] {3,6});
        System.out.println();
        testarr.print2d();
        testarr.appendRow(new int[] {4,2,9});
        System.out.println();
        testarr.print2d();
        */




         
        




        

        

        

       
        
    }
    
}
