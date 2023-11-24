public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<Integer>();
        list.insert(2);
        list.insert(4);
        list.insert(6);
        System.out.println(list);
        //System.out.println(list.find(6));
        list.delete(6);
        System.out.println(list);
       // list.insertBefore(list.find(6), 0);
        System.out.println(list);

    }
}
