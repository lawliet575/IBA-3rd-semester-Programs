public class Driver {

    public static void main(String[] args) {

        /*
        LinkedList_Queue<Integer> lq=new LinkedList_Queue<Integer>();
        lq.Enqueue(2);
        lq.Enqueue(5);
        lq.Enqueue(7);
        lq.Enqueue(9);
        lq.printlist();
        System.out.println(lq.Dequeue());
        lq.printlist();

        System.out.println();
 
        Array_Queue<Integer> aq=new Array_Queue<Integer>(5);
        aq.Enqueue(1);
        aq.Enqueue(2);
        aq.Enqueue(3);
        aq.Enqueue(4);
        aq.Enqueue(5);
        System.out.println(aq.Dequeue());
        aq.Enqueue(6);
        System.out.println(aq.Dequeue());
        aq.Enqueue(7);


        while(!aq.isEmpty()){
            System.out.print(aq.Dequeue()+" ");
        }


        
        */

        Priority_Queue<Integer> pq=new Priority_Queue<Integer>(5);
        pq.Enqueue(4);
        pq.Enqueue(6);
        pq.Enqueue(8);
        pq.Enqueue(2);
        pq.Enqueue(5);
        pq.Dequeue();
        System.out.println(pq);
        System.out.println(pq.peek());


        //MY PRINTJOB
        Priority_Queue<Myprinter> pr=new Priority_Queue<Myprinter>(7);
        Myprinter one=new Myprinter("job1", 5);
        Myprinter two=new Myprinter("job2", 2);
        Myprinter three=new Myprinter("job3", 2);
        Myprinter four=new Myprinter("job4", 1);
        Myprinter five=new Myprinter("job5", 8);
        pr.Enqueue(one);
        pr.Enqueue(two);
        pr.Enqueue(three);
        pr.Enqueue(four);
        pr.Enqueue(five);
        System.out.println("Printing Queue: "+pr);
        System.out.println("SHORTEST JOB DELETED FIRST: "+ pr.Dequeue());
        System.out.println("Printing Queue: "+pr);
        System.out.println("Peek--> Element to be deleted next is: " +pr.peek());



       


        









    }

}
