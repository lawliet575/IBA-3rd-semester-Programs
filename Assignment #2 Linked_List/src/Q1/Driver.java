package Q1;
public class Driver {
    public static void main(String[] args) {

    Doubly_List l=new Doubly_List();
    l.addSorted(8);
    l.addSorted(6);
    l.addSorted(9);
    l.addSorted(4);
    l.addSorted(55);
    l.addSorted(2);
    l.addSorted(55);

    
    //System.out.println(l.isEmpty());
    System.out.println("Length= "+l.length());
    l.print();
    //l.removeAll(55);
    //l.print();

    //l.removeFirst(55);
    //l.print();

    //System.out.println(l.popHead());
    //l.print();

    //l.reverse();
    //l.print();

    //Node temp=l.find(8);
    //System.out.println(temp.data);


        Doubly_List l2=new Doubly_List();
        l2.addSorted(57);
        l2.addSorted(36);
        l2.addSorted(10);
        l2.addSorted(23);
        l2.print();

        l.addAll(l2);
        l.print();
       
       

    }
    
}
