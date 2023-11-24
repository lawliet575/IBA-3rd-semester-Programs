package Q2;

public class Driver {
    public static void main(String[] args) {
        // TASK 1-9 
        /* 
        MyArraylist<Integer> list=new MyArraylist<>(8);
        System.out.println(list.isEmpty()); 
        System.out.println("Empty list length= "+list.Length()); 
       
       list.addAtEnd(4); System.out.println("After adding 1 element Length=  "+list.Length()); 
       list.addAtEnd(2);
       list.addAtEnd(4);
       list.addAtEnd(4);
       list.addAtEnd(6);
       list.addAtEnd(4);
       list.addAtFront(2);
       list.addAtFront(1);
       list.addAtFront(0);
       list.Print();
       list.reverse();
       list.Print();
       list.removeAll(4);
       list.Print();
       list.removeFirst(6);
       list.Print();
      System.out.println(list.Find(1));
     */

       //FOR TASK 10
        
       Student s1=new Student("Ikhlas", 20 , 27096);
       Student s2=new Student("Abdullah", 25 , 27141);
       Student s3=new Student("Sharjeel", 15 , 26865);

       MyArraylist<Student> slist=new MyArraylist<>();
       slist.addAtEnd(s1);
       slist.addAtFront(s2);
       slist.addAtEnd(s3);
       slist.Print();
       System.out.println("AFTER SORTING");
       slist.sort();
       slist.Print();
       






       
       

       
       
    }
}
