public class Array_Stack <T extends Comparable<T> > {
    T stacklist[];
    int top;

    Array_Stack(int size){
        stacklist= (T[]) new Comparable[size];
        top=-1;
    }

    public Boolean isEmpty(){
        if(top==-1){
            return true;
        }
        else return false;
    }

    public Boolean isFull(){
        if(top==stacklist.length-1){
            return true;
        }
        else return false;
    }

    public void push(T d){
        if(isFull()){
            System.out.println("FULL STACK");
            return;
        }

        top++;
        stacklist[top]=d;

    }

    public T pop(){
        if(isEmpty()){
            System.out.println("EMPTY STACK");
            return null;
        }

        T temp=stacklist[top];
        top--;
        return temp;
    }

    public T peek(){
         if(isEmpty()){
            System.out.println("EMPTY STACK");
            return null ;
        }

        return stacklist[top];

    }

    public void print(){
        if(isEmpty())
        return;

        for (int i =top; i>=0; i--) {
            System.out.print(stacklist[i]+" ");
        }
        System.out.println();
    }

    
    
}
