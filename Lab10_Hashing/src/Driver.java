import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Driver {
    public static void main(String[] args) {
        // hashing chaining
        /*
          HashT<String> hashTable = new HashT<>(5); // Create a hash table with 5 buckets
          
          // Insert some elements
          hashTable.insert("apple");
          hashTable.insert("orange");
          hashTable.insert("banana");
          
          // Check if elements are present
          System.out.println("Is 'apple' in the hash table? " +
          hashTable.find("apple"));
          System.out.println("Is 'orange' in the hash table? " +
          hashTable.find("orange"));
          System.out.println("Is 'banana' in the hash table? " +
          hashTable.find("banana"));
          
          // Delete an element
          hashTable.delete("apple");
          
          // Check if the deleted element is still present
          System.out.println("Is 'apple' in the hash table after deleting? " +
          hashTable.find("apple"));
          
          // Display the contents of the hash table
          System.out.println("\nContents of the hash table:");
          hashTable.displayTable();

         */
          
         


          

        // hashing addressing
        HashingOpenAdd h = new HashingOpenAdd(35000);
        try {
            FileInputStream fstream = new FileInputStream("Dictionary.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                String[] word = strLine.split(",");
                h.insert(word[0]);
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        h.displayTable();

         

    }

}
