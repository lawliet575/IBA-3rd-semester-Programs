public class BST_Arr <T extends Comparable <T> > {
    T[] tree;

    BST_Arr(int size){
     tree=(T[]) new Comparable[size];  
    }

    public void insert(T val){
        int index=0;

        while(index<tree.length && tree[index]!=null){
            if(val.compareTo(tree[index])<0){//move left
                index=(2*index)+1;
            }
            else if(val.compareTo(tree[index])>0){//move right
                index=(2*index)+2;
            }
        } //breaks when i have found an epty space or no space

        if(index<tree.length){
            tree[index]=val;
        }
    }

    public void find(T val){
        int index=0;

        while(index<tree.length && tree[index]!=null){
            if(val.compareTo(tree[index])==0){
                System.out.println("VALUE FOUND AT INDEX "+index);
                return;
            }
            else if(val.compareTo(tree[index])<0){//move left
                index=(2*index)+1;
            }
            else if(val.compareTo(tree[index])>0){//move right
                index=(2*index)+2;
            }
        } //breaks when i reached end of tree and not found value

        System.out.println("VALUE NOT FOUND");

    }



    public void print_tree(){
        for (int i = 0; i < tree.length; i++) {
            if(tree[i]==null){
                System.out.print(" -1 ");
            }
            else{
                System.out.print(tree[i]+" ");
            }
            
        }
        System.out.println();
    }

    public void traversal(){ //doing inorder
        if(tree[0]==null){//empty tree
            return;
        }

        inOrder(0); //sent as root
        System.out.println();
    }

    private void inOrder(int index){
        if( index>=tree.length){
            return;
        }

        inOrder((2*index)+1); //all left vals
        if(tree[index]!=null){
            System.out.print(tree[index]+" ");
        }
        inOrder((2*index)+2);//all right vals

    }

    private int find_index(T val){
          int index=0;//index to delete

        while(index<tree.length && tree[index]!=null){
            if(val.compareTo(tree[index])==0){
                return index;
            }
            else if(val.compareTo(tree[index])<0){//move left
                index=(2*index)+1;
            }
            else if(val.compareTo(tree[index])>0){//move right
                index=(2*index)+2;
            }
        } //breaks when i reached end of tree and not found value

        return -1;

    }

    public void delete(T val){
        int index=find_index(val);//index to be deleted
        if(index==-1){
            System.out.println("NOT FOUND");
            return;
        }
     //NOW I DELETE USING THE 3 CASES EASY PZ


     //BUT FIRST SET THESE
     int parent=(index-1)/2; //parent index can find value now if i write tree[parent]
     int left=(2*index)+1;   // right  ""  " " tree[right]
     int right=(2*index)+2;  // left  ""  " "  tree[left]
     
    
    
     //CASE-1 NO CHILDREN LEFT AND RIGHT NULL
     if(tree[left]==null && tree[right]==null){
         tree[index]=null; //deleted leaf node
         return;
     }

     //CASE-2 1 CHILD
     //ONLY LEFT so right is null 2 cases for this
      if(tree[right]==null){

         if(tree[index].compareTo(tree[parent])<0){ //tree[index]<tree[parent]
            //parent ka left=index ka left
            int parent_left=(2*parent)+1;
            tree[parent_left]=tree[left];
         }

         else if(tree[index].compareTo(tree[parent])>0){ //tree[index]>tree[parent]
            //parent ka right=index ka left
            int parent_right=(2*parent)+2;
            tree[parent_right]=tree[left];
         }

         tree[left]=null;//cuz left wala already index pe chala gya hai and index is deleted so to avoid duplicates
         return;

      }

     if(tree[left]==null){

        if(tree[index].compareTo(tree[parent])<0){//tree[index]<tree[parent]
            //parent ka left= index ka right
            int parent_left=(2*parent)+1;
            tree[parent_left]=tree[right];
            

        }

        else if(tree[index].compareTo(tree[parent])>0){ //tree[index]>tree[parent]
            //parent ka right=index ka right
            int parent_right=(2*parent)+2;
            tree[parent_right]=tree[right];
         }

         tree[right]=null;
         return;
     }

     //CASE 3--> 2 CHILDREN
     //last case where left and right both not null
     int inorder_succesor=find_inorder_successor(right);//right subtree leftmost value
     T value=tree[inorder_succesor];//value stored
     delete(tree[inorder_succesor]);// now delete successor
     tree[index]=value;//replace successor     
     return;


    } 

    public int find_inorder_successor(int index){//null checks already upar se ayenge to zrurat nahi hai
     //secondly do remeber ye index deleted node ka right child hoga already when passing so less checks
     //ab only i need to find left most index of this 
     
     while(tree[ (2*index)+1 ]!=null ){ //jab tak next left vali value null nahi ajati
        index=(2*index)+1;//traversing in left
     }
     //when loop breaks we are are left most jiski left already null hai means tree[ (2*index)+1 ]=null
    return index;



    }
    


    }
