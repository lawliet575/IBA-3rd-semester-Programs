public class LinkedList_Stack <T extends Comparable<T> >  {
    Node<T> top;

    LinkedList_Stack(){
        top=null;
    }

    public Boolean isEmpty(){
        if(top==null){
            return true;
        }

        else return false;
    }

    public void push(T d){
        Node<T> newnode=new Node<T>(d);
        if(isEmpty()){
            top=newnode; //only inserted newnode at beginning
            return;
        }

        //wrna do add first as top pe add hoga
        newnode.next=top;
        top=newnode;

    }

    public T pop(){
        if(isEmpty()){
            System.out.println("EMPTY STACK");
            return null;
        }

        T temp=top.data;
        top=top.next;
        return temp;
    }

    public T peek(){
        if(isEmpty()){
            System.out.println("EMPTY STACK");
            return null;
        }

        T temp=top.data;
        return temp;

    }


    public void print_stack(){
        if(isEmpty()){
            System.out.println("EMPTY STACK");
            return ;
        }

        Node<T> current=top;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();


    }


    
}
