public class Driver {
    public static void main(String[] args) {
        Heap<Integer> h=new Heap<>(6);
        h.insert(10);
        h.insert(8);
        h.insert(5);
        h.insert(4);
        h.insert(20);
        h.printheap();

        //int val=h.extractMax();
        //System.out.println(val);
        //System.out.println();
        //h.printheap();

        //System.out.println(h.find(4));

       System.out.println();
        //h.update(10, 50);
        //h.printheap();

        h.remove(10);
        h.printheap();




    }
    
}
