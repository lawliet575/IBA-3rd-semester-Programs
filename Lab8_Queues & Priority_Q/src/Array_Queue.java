public class Array_Queue <T> {
    int front=-1;
    int rear=-1;
    T[] arr;
    int size;

    Array_Queue(){
        arr=(T[]) new Object[10];
        front=rear=-1;
        this.size=10;
    }

    Array_Queue(int size){
        arr=(T[]) new Object[size];
        front=rear=-1;
        this.size=size;;

    }

    public boolean isEmpty(){
        if(front==-1 && rear==-1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if((rear+1) % size == front ){
            return true;
        }
        return false;
    }

    public void Enqueue(T obj){
        if(isFull()){
            return;
        }
        if(front==-1){ //empty queue
            front=0;
        }
        rear=(rear+1)%size;
        arr[rear]=obj;//add in queue
    }

    public T Dequeue(){
        if(isEmpty()){
            return null;
        }

        T result=arr[front];

        if(rear==front){//only 1 element
            rear=front=-1;
            return result;
        }

        front=(front+1)%size;

        return result;
    }





}
