public class Node<T> {
    T data;
    Node next;
    Node prev;

    Node(T data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
