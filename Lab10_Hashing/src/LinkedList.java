public class LinkedList <T> {
    Node<T> head;

    LinkedList(){
     head=null;
    }

    public String toString(){ //printing the list
        if(head==null){
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

    public void insert(T data){ //addfirst
        Node<T> newnode= new Node<T>(data);

        if(head==null){
            head=newnode;
            return;
        }

        newnode.next=head;
        head=newnode;

    }

    public Node<T> find(T data){
      if(head==null) {
          return null;
      }

      Node<T> current=head;
      while(current!=null){
        if(current.data.equals(data)){
        return current;
        }
        current=current.next;
      }
      System.out.println("NOT FOUND");
      return null;
    }

    public void clear(){
        head=null;
    }

    public void delete(T d){
        if(head==null) {
          return ;
      }

      if(head.data.equals(d)){ //first element
        head=head.next;
        return;
      }

      Node<T> current=head;
      while(current!=null){
        if(current.next.data.equals(d)){
            break;
        }
        current=current.next;
      }
      if(current.next.next==null){ //last element so current is at second last so uske next ko null krdo
        current.next=null;
        return;
      }

      current.next=current.next.next;
    }

    public void insertBefore(Node<T> n,T d){
         if(head==null) {
          System.out.println("Empty List");
          return ;
      }

      if(find(n.data)==null){
        System.out.println("Not found in list");
        return;
      }
    //at this point i know that node n exists in my code

      Node<T> newnode=new Node<T>(d);

      if(n==head){ 
        newnode.next=head;
        head=newnode;
        return;
      }


      Node<T> current=head;
      while(current.next!=n){
        current=current.next;
      }

      newnode.next=current.next;
      current.next=newnode;

    }






}
