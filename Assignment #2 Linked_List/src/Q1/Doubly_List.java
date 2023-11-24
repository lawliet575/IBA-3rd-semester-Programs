package Q1;

public class Doubly_List {
    Node head;
    Node tail;

    Doubly_List() {
        head = null;
        tail = null;
    }

    public boolean isEmpty() {
        if(head==null)
            return true;
        
         else return false;
        
        
    }

    public int length() {
        if (head == null) {
            return 0;
        }

        Node current = head;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    public void print() {
        if (head == null) {
            System.out.println("Empty list");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void addAsHead(int d) {
        Node newnode = new Node(d);
        if (head == null) { // empty list
            head = tail = newnode;
        } 
        else {
            newnode.next = head;
            head.prev = newnode; 
            head = newnode;
        }
    }

    public void addAsTail(int d) {
        Node newnode = new Node(d);
        if (head == null) { // empty list
            head = tail = newnode;
        } else {
            tail.next=newnode;
            newnode.prev=tail;
            tail=newnode;
        }
    }

    public void addSorted(int d) {
        Node newnode = new Node(d);
        if (head == null) { // empty list
            head = tail = newnode;
            return;
        }

        if (d <= head.data) { // value lesser than first value so add first
            addAsHead(d);
            return;
        }

        if (d >= tail.data) { // value greater than last so add last
            addAsTail(d);
            return;
        }

        Node current = head; 
        while (current.next.data <= d) { //max n times chalega so O(n)
            current = current.next;
        }


        newnode.next = current.next;//newnode pointing to next element
        newnode.prev = current; //newnode pointing to current element

        //breaking connections of current and current.next
        newnode.next.prev=newnode;//can also d current.next.prev=newnode;
        current.next=newnode;

    }

    public Node find(int d) {
        if (head == null) {
            System.out.println("Cannot find in an empty list");
            return null;
        }

        Node current = head;
        while (current != null) { //n times
            if (current.data == d) {
                return current;
            }
            current = current.next;
        }

        System.out.println("NOT FOUND");
        return null;
    }

    public void reverse() {
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node prev=null;
        Node curr=head;
        Node next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;

            //UPDATING
            prev=curr;
            curr=next;
        }
        head=prev;//no need to break 1st connection as prev starts  as null

        
    }

    public int popHead() {
        if (head == null) {
            System.out.println("NULL");
            return -1;
        }

        int temp = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null; 
        }
        return temp;
    }

    public void removeFirst(int d) { //remove first occurance of d
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        if(head.next==null && head.data==d){//1 element and wohi remove krna
        head=tail=null;
        return;
        }

       
        Node current = head;
        while (current != null) {

            if (current.data == d) {
                if(current.data==head.data){//1st element in a lambi linked list
                    head=head.next;
                    head.prev=null;
                    return;
                }
                current.prev.next = current.next; //centre element
                if (current.next != null) { //handle if last node to be removed as last.next=null so uspe nahi chalega
                    current.next.prev = current.prev;//doing this only for centre element not for last element as at last current.next is already null
                }
                return;
            }
            current = current.next;
        }
    }

    public void removeAll(int d) { //removeall occurances of d
        if (head == null) {
            System.out.println("Empty List");
            return;
        }

        Node current = head;
        while (current!=null){ 
            if(current.data==d){
                removeFirst(d);
            }
            current=current.next;

        }
       
    }

    public void addAll(Doubly_List list) {
        if (this.head == null) { // this list is empty, and the incoming list becomes this list
            this.head = list.head;
            this.tail = list.tail;
            return;
        } 

            tail.next = list.head; // this list's tail points to the incoming list's head
            list.head.prev = tail; // incoming list's head points back to this list's tail
            tail = list.tail; // update the tail to be the incoming list's tail
        
    }
}
