public class vertex {
    String name;
    int age;
    LinkedList<vertex> friendslist=new LinkedList<vertex>();


    vertex(String d,int a){
        name=d;
        age=a;
    }


    @Override
    public String toString() {
      return name+" "+age;
    }

    

    
}
