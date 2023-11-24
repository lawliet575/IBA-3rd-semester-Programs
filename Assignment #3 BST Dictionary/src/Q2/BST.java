package Q2;

public class BST {
    Node root;

    public Node getroot(){
        return this.root;

    }

    public void setroot(Node temp){
        if(this.root==null){
            root=temp;
        }
        else return;
    }


    public void inorder(Node root){
        if(root==null){
           return;
        }
        inorder(root.left);
        System.out.println(root.word+" "+root.meaning);
        inorder(root.right);
       }

        public String inorderString(Node root){
            if (root == null) {
                return "";
            }
        
            StringBuilder stringBuilder = new StringBuilder();
        
            stringBuilder.append(inorderString(root.left));
            stringBuilder.append(root.word + " " + root.meaning+"\n");
            stringBuilder.append(inorderString(root.right));
        
            return stringBuilder.toString();
       }

       public void traverse(Node root){ //level order
        Queue<Node> q=new Queue<Node>();
        q.Enqueue(root); 
        q.Enqueue(null);//1st level added along with null for line change
        
        while(!q.isEmpty()){
            Node current=q.Dequeue();
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
                System.out.print(current.word+" ");
                if(current.left!=null){
                    q.Enqueue(current.left);
                }
                if(current.right!=null){
                    q.Enqueue(current.right);
                }
            }
        }    
    }


    public void insert(String word,String meaning){
        insert(getroot(), word, meaning);
    }
    
    private Node insert(Node root,String word,String meaning){
        if(root==null){
            root=new Node(word, meaning);
            setroot(root);
             return root;
         }
 
         if(word.compareToIgnoreCase(root.word)<0){//move left
             root.left=insert(root.left, word, meaning);
         }
         else if(word.compareToIgnoreCase(root.word)>=0){//move left
             root.right=insert(root.right, word, meaning);
         }
 
         return root;
    }

    public Node find(String word){//finding word
        if(this.root==null){
            return null;
        }

        Node current=root;
        while(current!=null){
            if(current.word.equalsIgnoreCase(word)){
                System.out.println("WORD FOUND");
                return current;
            }
            else if(word.compareToIgnoreCase(current.word)<0){
                current=current.left;
            }
            else if(word.compareToIgnoreCase(current.word)>0){
                current=current.right;
            }
        }

        System.out.println("NOT FOUND");
        return null;

    }

    public void delete(String word){
        delete(getroot(),word);
       }
    
       private Node delete(Node root, String word){ //RECURSIVE
        if(word.compareToIgnoreCase(root.word)<0){
            root.left=delete(root.left,word); //move to left
        }
        else if(word.compareToIgnoreCase(root.word)>0){
            root.right=delete(root.right, word); //move to right
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
            Node ino_succ=inorderSuccessor(root.right);// find succesor which is --> right subtree ke left movst value
            root.word=ino_succ.word; //replace successor by node to delete
            root.meaning=ino_succ.meaning;
            root.right=delete(root.right,ino_succ.word);//delete the successor
    
        }
    
        return root;
    
       }
    
       public Node inorderSuccessor(Node root){
        while(root.left!=null){
            root=root.left;
        }
        return root;
    
       }

       public Node createbst(MyArraylist<Node> arr,int st,int end){
        if(st>end){
            return null;
        }

        int mid=(st+end)/2;
        String word=arr.get(mid).word;
        String meaning=arr.get(mid).meaning;
        Node root=new Node(word, meaning);
        setroot(root);
        root.left=createbst(arr, st, mid-1);
        root.right=createbst(arr, mid+1, end);

        return root;

       }

    
    
}
