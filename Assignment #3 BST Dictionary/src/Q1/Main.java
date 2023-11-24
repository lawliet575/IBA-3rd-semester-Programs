package Q1;

public class Main {

    public static void main(String[] args) {
        BST_ b=new BST_();
        b.insert(10);
        b.insert(5);
        b.insert(20);
        b.insert(12);
        b.insert(b.getroot(), 30);
        b.insert(8);
        b.insert(4);
        //b.inorder(b.getroot());
        b.PrintinRange(b.getroot(), 10 , 30);
    }
   
    
}
