public class Main {

    public static void main(String[] args) {

         /* 
        DLinkedList<Integer> d1=new DLinkedList<>();
        d1.InsertINOrder(8);
        d1.InsertINOrder(10);
        d1.InsertINOrder(2);
        d1.InsertINOrder(1);
        d1.InsertINOrder(5);
        d1.InsertINOrder(15);
        System.out.println(d1);
        d1.ReverseList();
        System.out.println(d1);
        System.out.println(d1.Length());
        d1.Delete(5);
        d1.Delete(15);
        System.out.println(d1);
        */


       /* 
        DLinkedList<String> d2=new DLinkedList<>();
        d2.InsertINOrder("ball");
        d2.InsertINOrder("cat");
        d2.InsertINOrder("zebra");
        System.out.println(d2);
        System.out.println(d2.Length());
        System.out.println(d2.isEmpty());   
        d2.ReverseList();
        System.out.println(d2);
        d2.Delete("cat");
        System.out.println(d2);
        Node temp=d2.Find("ball");
        System.out.println(temp.data);
       // d2.clearList(); System.out.println(d2);
        */
         
         DLinkedList<Student> d3=new DLinkedList<>();
         //NOTE I HAVE SORTED ACCORDING TO ID NUMBERS THIS TIME
         Student s1=new Student("Ikhlas", 20, 200);
         Student s2=new Student("Sharjeel", 15, 500);
         Student s3=new Student("Itbaan", 80, 50);
         d3.InsertINOrder(s1);
         d3.InsertINOrder(s3);
         d3.InsertINOrder(s2);
         System.out.println(d3);
         d3.ReverseList();
         System.out.println(d3);
         d3.Delete(s3);
         System.out.println(d3);
         System.out.println(d3.isEmpty());
         System.out.println(d3.Length());
         d3.Find(s1);






        




    }
    
}
