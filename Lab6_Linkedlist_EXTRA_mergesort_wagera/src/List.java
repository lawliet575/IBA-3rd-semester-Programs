public class List {
    Node head;

    List(){
        head=null;
    }


    public boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public int length(){
        if(head==null){
            return 0;
        }

        Node current=head;
        int count=0;

        while(current!=null){
        count++;
        current=current.next;
        }

        return count;
    }

    public void print(){
        if(head==null){
            System.out.println("Empty list");
            return;
        }

        Node current=head;
        while(current!=null){
        System.out.print(current.data+" ");
        current=current.next;
        }
        System.out.println();

    }


    public void Addlast(int d){
            Node newnode=new Node(d);
        
        if(head==null){
            head=newnode;
            return;
        }
        Node current=head;
        while(current.next!=null){
            current=current.next;
        }
        current.next=newnode;
    
    }


    public void findmiddle(){
        if(head==null){
            System.out.println("EMPTY LIST");
            return;
        }
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;;
        }

        //slow is my mid at end
        System.out.println("MIDDLE NODE= "+slow.data);
    }

    public List SortedMerge(List one,List two){//assuming one and two are already sorted
        if(one.isEmpty()){
            return two;
        }

        if(two.isEmpty()){
            return one;
        }

        List temp=new List();
        Node c1=one.head; 
        Node c2=two.head; 


        while(c1!=null && c2!=null){
        
            //checks for c1=null or c2=null
            if(c1.data<c2.data){
                temp.Addlast(c1.data);
                c1=c1.next;
            }

            else if(c2.data<c1.data){
                temp.Addlast(c2.data);
                c2=c2.next;
            }

            else { //c2.data==c1.data
                temp.Addlast(c1.data);
                temp.Addlast(c2.data);
                c1=c1.next;
                c2=c2.next;
            }

        }

        //loop might break with c1 as null and c2 remaining and vice versa
        if(c1==null){ //c2 is remaining
            while (c2!=null) {
                temp.Addlast(c2.data);
                c2=c2.next;
            }
        }
        

        else if(c2==null){ //c1 is remaining
            while (c1!=null) {
                temp.Addlast(c1.data);
                c1=c1.next;
            }
        }

        return temp;
    }








    
}
