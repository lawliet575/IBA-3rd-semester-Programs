package Q4;

public class TwoDimensionalDynamicArray {
    static int curr_row;
    static int curr_col;
    static int[][] arr;


    public TwoDimensionalDynamicArray(int row, int col) {
        arr=new int[row][col];
        for (int i = 0; i < arr.length; i++) { //rows top to bottom
            for (int j = 0; j < arr[i].length; j++) { //cols left to right
                arr[i][j]=  ( (int)(1+Math.random()*9));
                curr_col=j;
            }
            curr_row=i;
        }
        
        
    }


    public void print2d(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+",");
            }
            System.out.println();
        }
    }


    public void appendRow(int[] rowArray){

        if(rowArray.length>curr_col+1){ //FIRST CHECK
            System.out.println("Cannot add, Invalid ROW");
             return ;
        } 
         
        
        //LAST ROW CHECK FOR ZERO OR NONZERO
        boolean zero_row_check=true; //true means zero row exists and no need to create new temp2d array
        if(curr_row+1==arr.length)
        zero_row_check=false; //false means zero row doesnt exist and new temp2d array to banegi
        
        
    

        if(zero_row_check==false){ //LAST ROW IS NONZERO AND WE HAVE TO ADD NEW ROW NOW USING TEMP 2D ARRAY
            int[][] temp2d=new int[arr.length*2][arr[0].length]; //double rows but same columns

            //FOR COPYING ARRAY TO TEMP2D
            for (int i = 0; i <=curr_row; i++) {
                for (int j = 0; j <=curr_col; j++) {
                    temp2d[i][j]=arr[i][j];
                }    
            }
            arr=temp2d;//referance copy now arr becomes the new array with double rows and same columns
            
           //INSERTING INCOMING ARRAY VALUES TO THE ARRAY (Appending)
           curr_row++;
           for (int j = 0; j <rowArray.length; j++) {
            arr[curr_row][j]=rowArray[j];
           }
        }


         else if(zero_row_check==true){ //LAST ROW IS ZERO AND WE WILL OVERWRITE NEW ARRAY
            curr_row++;
            for (int j = 0; j <rowArray.length; j++) {
                arr[curr_row][j]=rowArray[j]; //copied new array to last row of the 2d array
            }
        }
    }


    public void appendCol(int[] colArray){

        if(colArray.length>curr_row+1){ //FIRST CHECK
            System.out.println("Cannot add, Invalid COLUMN");
             return ;
        } 
         
        
        //LAST Column CHECK FOR ZERO OR NONZERO
        boolean zero_col_check=true; //true means zero col exists and no need to create new temp2d array
        if(curr_col+1==arr[0].length)
        zero_col_check=false; //false means zero col doesnt exist and new temp2d array to banegi
        
        
    

        if(zero_col_check==false){ //LAST ROW IS NONZERO AND WE HAVE TO ADD NEW COL NOW USING TEMP 2D ARRAY
            int[][] temp2d=new int[arr.length][arr[0].length*2]; //same rows but double columns

            //FOR COPYING ARRAY TO TEMP2D
            for (int i = 0; i <=curr_row; i++) {
                for (int j = 0; j <=curr_col; j++) {
                    temp2d[i][j]=arr[i][j];
                }    
            }
            arr=temp2d;//referance copy now arr becomes the new array with Same rows and Double columns
            
           //INSERTING INCOMING ARRAY VALUES TO THE ARRAY (Appending)
           curr_col++;
           for (int i = 0; i <colArray.length; i++) {
            arr[i][curr_col]=colArray[i];
           }
        }


         else if(zero_col_check==true){ //LAST COL IS ZERO AND WE WILL OVERWRITE NEW ARRAY
            curr_col++;
            for (int i = 0; i <colArray.length; i++) {
                arr[i][curr_col]=colArray[i]; //copied new array to last col of the 2d array
            }
        }

        

    }


    










    
}

