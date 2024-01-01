public class Queue <T> {
    Node<T> front; //T TYPE
    Node<T> rear;

    public boolean isEmpty(){
        if(front==null && rear==null){
            return true;
        }
        return false;
    }

    public void Enqueue(T obj){ //addlast
        Node<T> newnode=new Node(obj);
        if(rear==null){ //empty list
            rear=front=newnode;
            return;
        }
        rear.next=newnode;
        rear=newnode;
    }

    public T Dequeue(){ //removefirst
        if(isEmpty()){
            return null;
        }

        T data=front.data; //STORE DATA

        //UPDATE QUEUE
        if(front==rear){ //only 1 element
            front=rear=null;
            return data;
        }

        front=front.next; //MORE THAN ONE ELEMENT

        return data;
    }

    public void printlist(){
        Node<T> current=front;
        while(current!=null){
            System.out.print(current.data+" ");
            current=current.next;
        }
        System.out.println();
    }




}
