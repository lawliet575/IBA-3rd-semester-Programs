public class Driver {
    public static void main(String[] args) throws Exception {
        //FOR TASK 1 MIDDLE
        
        List mylist=new List();
        mylist.Addlast(5);
        mylist.Addlast(9);
        mylist.Addlast(2);
        mylist.Addlast(1);
        mylist.findmiddle();
        

        //FOR TASK 2 MERGESORT
        List l1=new List();
        l1.Addlast(1);
        l1.Addlast(2);
        l1.Addlast(9);

         List l2=new List();
        l2.Addlast(3);
        l2.Addlast(6);
        l2.Addlast(8);

       List temp=new List();
        temp=temp.SortedMerge(l1, l1);
        temp.print();




    }
}
