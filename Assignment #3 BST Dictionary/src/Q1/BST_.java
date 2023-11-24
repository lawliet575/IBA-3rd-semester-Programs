package Q1;

public class BST_ {

    Node_ root;

    BST_(){
        this.root=null;
    }

    public Node_ getroot(){
        return this.root;
    }

    public void setroot(Node_ temp){
//first time me root set hojayega phir baqi jab bhi call hoga it wont update
        if(this.root==null)
        this.root=temp;
        else return;
    }

    public void insert (int val){ // NON RECURSIVE 
        Node_ newNode = new Node_(val);
       if (root == null) {
           root = newNode;
           return;
       }

       Node_ temp = root;
       Node_ prev = null;

       while (temp != null) {
           prev = temp;
           if (val<temp.data) {
               temp = temp.left;
           } else if (val>temp.data) {
               temp = temp.right;
           }
       }

       if (val<prev.data) {
           prev.left = newNode;
       } else {
           prev.right = newNode;
       }
   }
    
    public Node_ insert(Node_ root,int val){ //RECURSIVE
        if(root==null){
            root=new Node_(val);
            setroot(root); //do this only if class me root ka var ho and one time hoga bas ye
            return root;
        }

        if(val<root.data){
            root.left=insert(root.left, val);
        }

        else{
           root.right=insert(root.right, val); 
        }

        return root;
    }

    public void inorder(Node_ root){ // inorder traversal LNR
        if(root==null){
            return;
        }

        inorder(root.left);
        System.out.println(root.data+" ");
        inorder(root.right);
    }

   public void PrintinRange(Node_ root,int k1,int k2){ //do know that 
    if(root==null){
            return;
        }

        if( root.data>=k1 && root.data<=k2){
            PrintinRange(root.left, k1, k2);
            System.out.print(root.data+" ");
            PrintinRange(root.right, k1, k2);
        }
        else if(root.data>k2){ //max se bhe bara so all vals on left
            PrintinRange(root.left, k1, k2);
        }
        else if(root.data<k1){ //min se bhe chota so all values on right
            PrintinRange(root.right, k1, k2);
        }

    }

}




    

