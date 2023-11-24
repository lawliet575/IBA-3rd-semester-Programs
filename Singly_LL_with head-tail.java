package Q1;
public class List {
    Node head;
    Node tail;

    List(){
        head=null;
        tail=null;
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

    public void AddAsHead(int d){
        Node newnode=new Node(d);
        if(head==null){ //empty list
            head=tail=newnode;
            return;
        }

        newnode.next=head;
        head=newnode;
    }

    public void AddAsTail(int d){
     Node newnode=new Node(d);
     if(head==null){ //empty list
      head=tail=newnode;
      return;
    }

    tail.next=newnode;
    tail=newnode;
    }

    public void AddSorted(int d){ //ascending order 1,2,3,4,5,6....
        Node newnode=new Node(d);
        if(head==null){ //empty node
            head=tail=newnode;
            return;
        }

        if(d<=head.data){//value lesser than first value so addfirst
        AddAsHead(d);
        return;
        }

        if(d>=tail.data){ //value greater than last so addlast
            AddAsTail(d);
            return;
        }

        Node current=head; //value addition in between
        while(current.next.data<=d){
            current=current.next;
        }
        newnode.next=current.next;
        current.next=newnode;
    }

    public Node find(int d){
        if(head==null){
            System.out.println("Cannot find empty list");
            return null;
        }

        if(head.data==d){ //found at start
            return head;
        }

        if(tail.data==d){ //found at end
            return tail;
        }

        Node current=head; // found in between
        while(current!=null){ //worst case pe n times chalega
            if(current.data==d){
                return current;
            }
            current=current.next;
        }

        System.out.println("NOT FOUND");
        return null;
    }

    public void reverse(){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
       
        Node prev=null;
        Node current=tail=head; //since after reversing my tail now becomes head shru me he update krdya
        Node next;

        while(current!=null){ //worst case pe n times chalega
            next=current.next;
            current.next=prev;
            prev=current;
            current=next; //can also do current=current.next
        }

        //list is reversed and prev is on last node
        head=prev;
    }

    public int popHead(){
        if(head==null){
            System.out.println("NULL");
            return -1;
        }

        int temp=head.data;
        head=head.next;
        return temp;
    }

    public void removeFirst(int d){
        if(head==null){
            System.out.println("Empty List");
            return;
        }

        if(head.data==d){
            head=head.next;
            return;
        }

        //Node toremove=find(d); //is se n square hoga order i wont use
        Node current=head;
        while(current.next.data!=d){
            current=current.next;
        }

        
        if(current.next==tail){
            current.next=null;
            tail=current;
            return;
        }
    
        current.next=current.next.next;
    }


    public void removeAll(int d){
         if(head==null){
            System.out.println("Empty List");
            return;
        }

        Node current=head;
        while(current!=null){
            if(current.data==d){
                removeFirst(d);
            }
            current=current.next;
        }

    }

    public void AddAll(List l){
        if(head==null){ //this list empty and aane vali list ke head pe point krdo
            this.head=l.head;
            return;
        }
       
        tail.next=l.head; //ye vali list is 1st then incoming list 2nd
    }






    
}
