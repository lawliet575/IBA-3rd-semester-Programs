package Q3;

import java.util.Scanner;

public class Customer implements Comparable<Customer> {
    String name;
    List<Video> rented_vids;
    int id;//every customer has a unique id


    public Customer(String name, int id) {
        this.name = name;
        this.rented_vids = new List<>();
        this.id=id;
    }

    public void Update_Details(){
        Scanner input=new Scanner(System.in);
        System.out.println("Enter 1 to change name, 2 to change id");
       int x=-1;
        while(true){
        x=input.nextInt();
        if(x==1 || x==2)
            break;
         System.out.println("Enter 1 or 2 only");   
       }        

       if(x==1){
        System.out.println("Enter new name");
        String newname=input.next();
        this.name=newname;
       }

       else{
        System.out.println("Enter new id");
        int newid=input.nextInt();
        this.id=newid;
       }




    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Video> getRented_vids() {
        return rented_vids;
    }

    public void setRented_vids(List<Video> rented_vids) {
        this.rented_vids = rented_vids;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void add_Rented_video(Video v){
        rented_vids.AddSorted(v);
    }

    public void remove_rented_video(Video v){
        rented_vids.removeFirst(v);
    }

    public Node<Video> get_rented_video_byid(int id){
        if(rented_vids==null){
            return null;
        }
        Node<Video> curr=rented_vids.gethead();
        while (curr!=null) {
            Video temp=curr.data;
            if(temp.getID()==id){
                return curr;//returns a video node ref
            }
            curr=curr.next;  
        }
        System.out.println("WRONG ID ENTERED");
        return null;

    
    }

    @Override
    public int compareTo(Customer c) {
        if(this.id>c.id)
            return 1;

            if(this.id<c.id)
            return -1;


             return 0;//same name
    
    }

    @Override
    public String toString(){
        return "Name: "+getName()+"\n"+
               "ID: "+getId()+"\n"+
               "RENTED VIDEOS: "+ rented_vids_string()+"\n";
    }

    public String rented_vids_string(){
       Node<Video> current=rented_vids.gethead();
       if(current==null){

        return "NO BOOKS RENTED CURRENTLY";
       }

       String str="";
       while(current!=null){
        Video temp=current.data;
        str+="TITLE: "+temp.getTitle()+" ";
        str+="ID: "+temp.getID()+"\n";
        current=current.next;
       }
       return str;
    }

}
