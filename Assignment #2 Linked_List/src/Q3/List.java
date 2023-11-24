package Q3;

public class List<T extends Comparable<T> > {
     Node<T> head;
     Node<T> tail;

    List(){
        head=null;
        tail=null;
    }

    public Node<T> gethead(){
        return head;
    }

    public Node<T> getTail(){
        return tail;
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

        Node<T> current=head;
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

        Node<T> current=head;
        while(current!=null){
        System.out.println(current.data+" "); //tostring of video object
        current=current.next;
        }

    }

    public void AddAsHead(T d){
        Node<T> newnode=new Node(d);
        if(head==null){ //empty list
            head=tail=newnode;
            return;
        }

        newnode.next=head;
        head=newnode;
    }

    public void AddAsTail(T d){
     Node<T> newnode=new Node(d);
     if(head==null){ //empty list
      head=tail=newnode;
      return;
    }

    tail.next=newnode;
    tail=newnode;
    }

    public void AddSorted(T d){ //ascending order 1,2,3,4,5,6....
        Node<T> newnode=new Node(d);
        if(head==null){ //empty node
            head=tail=newnode;
            return;
        }

        if(d.compareTo(head.data)<=0){//value lesser than first value so addfirst
        AddAsHead(d);
        return;
        }

        if(d.compareTo(tail.data)>=0){ //value greater than last so addlast
            AddAsTail(d);
            return;
        }

        Node<T> current=head; //value addition in between
        while(current.next.data.compareTo(d)<=0){
            current=current.next;
        }
        newnode.next=current.next;
        current.next=newnode;
    }

    public Node<T> find(T d){ //same type ka comparision hoga
        if(head==null){
            return null;
        }

        if(head.data.compareTo(d)==0){ //found at start
            return head;
        }

        if(tail.data.compareTo(d)==0){ //found at end
            return tail;
        }

        Node<T> current=head; // found in between
        while(current!=null){ //worst case pe n times chalega
            if(current.data.compareTo(d)==0){
                return current;
            }
            current=current.next;
        }

        return null;
    }

    public void reverse(){
        if(head==null){
            System.out.println("Empty List");
            return;
        }
       
        Node<T> prev=null;
        Node<T> current=tail=head; //since after reversing my tail now becomes head shru me he update krdya
        Node<T> next;

        while(current!=null){ //worst case pe n times chalega
            next=current.next;
            current.next=prev;
            prev=current;
            current=next; //can also do current=current.next
        }

        //list is reversed and prev is on last node
        head=prev;
    }

    public T popHead(){
        if(head==null){
            System.out.println("NULL");
            return null;
        }

        T temp=head.data;
        head=head.next;
        return temp;
    }

    public void removeFirst(T d){
        if(head==null){
            System.out.println("Empty List");
            return;
        }

        if(head.data.compareTo(d)==0){
            head=head.next;
            return;
        }

        //Node toremove=find(d); //is se n square hoga order i wont use
        Node<T> current=head;
        while(current.next.data.compareTo(d)!=0){
            current=current.next;
        }

        
        if(current.next==tail){
            current.next=null;
            tail=current;
            return;
        }
    
        current.next=current.next.next;
    }


    public void removeAll(T d){
         if(head==null){
            System.out.println("Empty List");
            return;
        }

        Node<T> current=head;
        while(current!=null){
            if(current.data.compareTo(d)==0){
                removeFirst(d);
            }
            current=current.next;
        }

    }

    public void AddAll(List<T> l){
        if(head==null){ //this list empty and aane vali list ke head pe point krdo
            this.head=l.head;
            return;
        }
       
        tail.next=l.head; //ye vali list is 1st then incoming list 2nd
    }

}
