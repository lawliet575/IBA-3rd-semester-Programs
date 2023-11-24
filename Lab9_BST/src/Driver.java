public class Driver {
    public static void main(String[] args) {

        //BST USING LINKED LIST IMPLEMENTATION
        BST_LL<Integer> tree=new BST_LL<Integer>();
        tree.insert(tree.getroot(), 10);
        tree.insert(tree.getroot(), 15);
        tree.insert(tree.getroot(), 5);
        Node<Integer> temp=tree.insert(tree.getroot(), 20);
        System.out.println(temp.data+"ehhe");
        tree.inorder(tree.getroot());
        //tree.traverse(tree.getroot()); // level order
        //tree.find(120);
        tree.delete(5); //DELETE METHOD USED
        tree.inorder(tree.getroot());


        //ARRAY BST
        BST_Arr<Integer> tree2=new BST_Arr<>(14);
        tree2.insert(15);
        tree2.insert(10);
        tree2.insert(20);
        tree2.insert(18);




        //tree2.print_tree();
        //tree2.find(4);

        tree2.traversal();//inorder traversal
        tree2.delete(15); //YESSS FINALLY 
        tree2.traversal();


        
        
    }
    
}
