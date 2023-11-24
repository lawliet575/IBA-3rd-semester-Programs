package Q2;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws IOException {

    /* 
    BST tree=new BST();
    tree.insert("Moon", "white");//first time root is null
    tree.insert("fish", "white");
    tree.insert("zebra", "white");
    tree.insert("apple", "white");
    tree.insert("grass", "greenooo");
    tree.inorder(tree.getroot());
       //tree.traverse(tree.getroot());
       //tree.delete("fish");
       //tree.traverse(tree.getroot());
       //Node temp=tree.find("grass");
       //System.out.println(temp.meaning);
      */

      //FILE READING
      java.io.File file=new java.io.File("Dictionary.csv");
      Scanner reader=new Scanner(file);
      ArrayList<Node> allwords=new ArrayList<>();
      //MyArraylist<Node> allwords=new MyArraylist<>();
      
      

      while (reader.hasNextLine()){
        String line=reader.nextLine();//stores the current line/
        String [] parts=line.split(",",2);
        String word=parts[0];
        String meaning=parts[1];
        
        Node temp=new Node(word, meaning);
        allwords.add(temp);
      }
      reader.close();


      //shuffle here
      Collections.shuffle(allwords);
      

       
      //now add in BST TREE
      BST dtree=new BST();
      for (int i = 0; i < allwords.size(); i++) {
        dtree.insert( allwords.get(i).word, allwords.get(i).meaning);
      }
      

      //dtree.traverse(dtree.getroot());//can check by level order that degenerated tree is not formed


     //NOTE THAT ANY CHANGES HERE WILL ALSO REFELECT ON THE WRIITE FILE

      dtree.insert("Apple", "Fruit");
      dtree.delete("Abaci");

      Node t=dtree.find("Abaciscus");
      System.out.println(t.meaning);


      //dtree.delete("Abaciscus");
      //dtree.find("Abaciscus");

      //dtree.inorder(dtree.getroot()); //traverse hai but console pe ni ata aj


      //FILE WRITING TO CHECK
      java.io.File wfile=new java.io.File("writedata.txt");
      java.io.FileWriter writer=new FileWriter(wfile);
      String data=dtree.inorderString(dtree.getroot());
      writer.write(data);
      writer.close();
      
    
    }
    
}
