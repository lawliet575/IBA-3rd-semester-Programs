public class Game {//it is cicurlar LL

    Node tail;
    int size;

    Game(){
        tail=null;
        size=0;
    }

    public void insert(String player){
        Node newnode=new Node(player);
        if(tail==null){ //for adding 1 eleement
       tail=newnode;
       tail.next=newnode; 
       size++; 
       return;      
        }
        newnode.next=tail.next; //last eleement ko first se jora
        tail.next=newnode;//tail ka next newnode ko point krega ye jante we last node(newnode) is pointing to first(tail.next)
        tail=newnode;//last ko tail bana do
        size++;

    }

    public String playGame(){
        Node current=tail.next;
        Node prev=tail;

        int R=((int)Math.random()*10); //0 to 9 random number
       //int R=4;
        while(current!=prev){

            for (int i = 0; i <=R; i++) {
                //updating
               prev=current;
               current=current.next;   
            }
            
            //now prev is before current
            prev.next=current.next;//current is removed
            size--;
            print();
        }


        return current.data;
        


    }

    public String toString(){
        if(tail==null){
            return "EMPTY LIST";
        }
        String temp="";
        Node current=tail.next;
        while(current!=tail.next){
            temp+=current.data;
            current=current.next;
        }
        return temp;
    }

    public void print(){
        Node curr=tail.next;
        for (int i = 0; i < size; i++) {
            System.out.print(curr.data+" "); 
            curr=curr.next;
        }
        System.out.println("");
    }

    
}
