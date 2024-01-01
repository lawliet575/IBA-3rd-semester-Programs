public class HashT<T> {
    LinkedList<T> buckets[];//array of linkedlist
    

    HashT(int s){ //constructor
        buckets=  new LinkedList[s+s/3];

        //initialize all the LL inside the buckets
        for (int i = 0; i < buckets.length; i++) {
            this.buckets[i]=new LinkedList<>();
        }
    }


    public int Hashfunction(T obj){
        
        int bi=obj.hashCode();
        return Math.abs(bi) % this.buckets.length;
    
         //wese its (key % buckets.length, since key always an int value
        //always returns a value b/w 0 and n-1

    }

    public void insert(T obj){
        int bi=Hashfunction(obj);
        buckets[bi].insert(obj); //newnnode inserted in that bucket    
    }

    public boolean find(T obj){
        int bi=Hashfunction(obj);
        //now traverse in that index of bucket of linkedlist
        Node<T> temp=buckets[bi].find(obj);
        if(temp!=null){
            return true;
        }
        else return false;
    }


    public void delete(T obj){
        int bi=Hashfunction(obj);
        buckets[bi].delete(obj);
    }

    public void displayTable(){
        for (int i = 0; i < buckets.length; i++) {

            LinkedList<T> temp=buckets[i];
            System.out.println(temp+"");//tostring of LL
        }

    }



    


    
}
