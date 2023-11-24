public class BST_LL<T extends Comparable <T> > { //BST USING LINKED LIST

    Node<T> root;

    BST_LL(){
        this.root=null;
    }

    public Node<T> getroot(){
        return this.root;
    }

    public void setroot(Node<T> temp){
//first time me root set hojayega phir baqi jab bhi call hoga it wont update
        if(this.root==null)
        this.root=temp;
        else return;
    }

    public void insert (T data){ // NON RECURSIVE 
        Node<T> newNode = new Node<>(data);
       if (root == null) {
           root = newNode;
           return;
       }

       Node<T> temp = root;
       Node<T> prev = null;

       while (temp != null) {
           prev = temp;
           if (data.compareTo(temp.data) < 0) {
               temp = temp.left;
           } else if (data.compareTo(temp.data) > 0) {
               temp = temp.right;
           }
       }

       if (data.compareTo(prev.data) < 0) {
           prev.left = newNode;
       } else {
           prev.right = newNode;
       }
   }
    
    public Node<T> insert(Node<T> root,T val){ //RECURSIVE
        if(root==null){
            root=new Node<T>(val);
            setroot(root); //do this only if class me root ka var ho and one time hoga bas ye
            return root;
        }

        if(val.compareTo(root.data)<0){
            root.left=insert(root.left, val);
        }

        else{
           root.right=insert(root.right, val); 
        }

        return root;
    }

    public void inorder(Node<T> root){
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }


    public void traverse(Node<T> root){ //LEVEL ORDER TRAVERSAL
        Queue<Node<T>> q=new Queue<>();
        q.Enqueue(root); 
        q.Enqueue(null);//1st level added along with null for line change
        
        while(!q.isEmpty()){
            Node<T> current=q.Dequeue();
            if(current==null){ //means we have completed the level now move to nextline
                System.out.println();
                
                //null me queue can also be empty so we have finished all lvels
                if(q.isEmpty()){
                    break;
                }
                else{
                    q.Enqueue(null);//since next line aur prev line ke beech me i need null
                }
            }

            else{
                System.out.print(current.data+" ");
                if(current.left!=null){
                    q.Enqueue(current.left);
                }
                if(current.right!=null){
                    q.Enqueue(current.right);
                }
            }
        }    
    }

   public Node<T> find(T key){ //NON RECURSIV
    if(root==null){
        System.out.println("NOT FOUND");
        return null;
    }

    Node<T> current=root;

    while(current!=null){
        if(key.compareTo(current.data)==0){
            System.out.println("FOUND");
            return current;
        }
        else if(key.compareTo(current.data)<0){//MOVE LEFT
            current=current.left;
        }
        else if(key.compareTo(current.data)>0){ //MOVE RIGHT
             current=current.right;
        }
    }

    System.out.println(" NOT FOUND");
    return null;

   } 

   //IN NON RECURSIVE U KEEP TRACK OF PREV AND CURRENT
   //CURRENT DELETE HOGA AND PREV IS THE PARRENT JO UPDATE HOGA KAHI SE CONNECT HOGA

   public void delete(T key){
    delete(getroot(),key);
   }

   private Node<T> delete(Node<T> root, T val){ //RECURSIVE
    if(val.compareTo(root.data)<0){
        root.left=delete(root.left,val); //move to left
    }
    else if(val.compareTo(root.data)>0){
        root.right=delete(root.right, val); //move to right
    }

    else{ //root.data==val value found
    
        //CASE 1 0 CHILDREN
        if(root.left==null && root.right==null){
            return null;
        }

        //CASE 2 --> 1 CHILD
        if(root.left==null){ //only right child exist connect it to grandparent beech ka parent kha jao
            return root.right;
        }
        if(root.right==null){ //only left child exist connect it to grandparent beech ka parent kha jao
            return root.left;
        }

        //CASE 3
        Node<T> ino_succ=inorderSuccessor(root.right);// find succesor which is --> right subtree ke left movst value
        root.data=ino_succ.data; //replace successor by node to delete
        root.right=delete(root.right,ino_succ.data);//delete the successor

    }

    return root;

   }

   public Node<T> inorderSuccessor(Node<T> root){
    while(root.left!=null){
        root=root.left;
    }
    return root;

   }







    







    
}
