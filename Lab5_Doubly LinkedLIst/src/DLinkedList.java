public class DLinkedList<T extends Comparable <T> > {
    Node<T> head;

    DLinkedList(){
        head=null;
    }

    public String toString(){ //printing the list
        if(head==null){
            System.out.println("EMPTY LIST");
            return "";
        }
        
        String temp="list= ";
        Node<T> current=head;
        while(current!=null){
            String data= String.valueOf(current.data);
            temp=" "+ temp + data+" ";
            current=current.next;
        }
        return temp;
    }

    public void InsertINOrder(T value){ 
        Node<T> newnode=new Node<T>(value);

        if(head==null){ //EMPTY LIST
         head=newnode;
         return;
        }

        if(head.data.compareTo(value)>=0){
            newnode.next=head;
            head.prev=newnode;
            head=newnode;
            return;
        }

        Node<T> current=head;

        

        while(current.next!=null){
            Node<T> temp=current.next;
            if(temp.data.compareTo(value)>=0){
                break;
            }
            current=current.next;
        }

       
        if(current.next==null){ //last element
        current.next=newnode;
        newnode.prev=current;
        return;
        }

        if(current==head){ //first element
            newnode.next=head;
            head.prev=newnode; //ask in grp ke head.prev krskte ya ni?
            head=newnode;
            return;
        }
        
        newnode.next=current.next;
        newnode.prev=current;
        newnode.prev.next=newnode;
        newnode.next.prev=newnode;

    }



    public void check(T val){
        Node<T> current=head;

        while(!current.data.equals(val)){
            current=current.next;
        }
        System.out.println(current.prev.data);

    }

    public Node Find(T value){
        if(head==null){ //EMPTY LIST
         return null;
        }

        Node<T> current=head;
         while(current!=null){
            if(current.data.equals(value)){
                return current;
            }
            current=current.next;
        }

        return null;
    }

    public void Delete(T value){

       
        if(head==null){ //EMPTY LIST
         return;
        }

        Node<T> current=head;

        while(current!=null){
            if(current.data.compareTo(value)==0){
                break;
            }
            current=current.next;
        }

        if(current==null){ //no such element found
            return;
        }

        if(current==head){ //first element to be removed
        head.next.prev=null;
        head=head.next;
        return;
        }

        if(current.next==null){ //last element to be removed
            current.prev.next=null;
            return;
        }

        current.prev.next=current.next; //MIDDLE ME ANY ELEMENT TO BE REMOVED
        current.next.prev=current.prev;

  


    }

    public void clearList(){
        head=null;
    }

    public Boolean isEmpty(){
        if(head==null){
            return true;
        }
        return false;
    }

    public int Length(){
        if(head==null){
            return 0;
        }

      Node<T> current=head;
      int temp=0;
      while(current!=null){
        temp++;
        current=current.next;
      }
      return temp;

    }

    public void ReverseList(){
        if(head==null){
            System.out.println("EMPTY LIST");
            return;
        }

        Node prev=null;
        Node current=head;
        Node next;

        while(current!=null){ //traversing till end
            next=current.next;
            current.next=prev;
            current.prev=next;

            prev=current;
            current=next;

        }

        head=prev;

        
    }










    
}
