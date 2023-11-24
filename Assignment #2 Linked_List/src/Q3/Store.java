package Q3;

import java.util.Scanner;

public class Store {
    List<Video> vids; //includes all videos
    List<Customer> all_customers; //all customers database
    Scanner input;


    Store(){
        vids=new List<Video>();
        all_customers=new List<Customer>();
        input=new Scanner(System.in);
    }



    public void addvideo(Video v){
    vids.AddSorted(v);
    }

    public void show_All_Customers(){
        if(all_customers.gethead()==null){
         System.out.println("NO CUSTOMERS YET");
         return ;
        }
        System.out.println();
        System.out.println("CURRENT CUSTOMERS; ");
        all_customers.print();
    }

    public void addCustomer(Customer c){ 
        //NOTE THAT CUSTOMERS ARE SORTED ACCORDING TO THEIR ID'S NOT NAMES
        all_customers.AddSorted(c);
    }

    public void updateCustomer_record(){
        if(all_customers.gethead()==null){
            System.out.println("NO CUSTOMERS YET");
            return;
        }

        show_All_Customers();
        System.out.println("Enter id of which customer you want to update");
        int id=input.nextInt();
        Node<Customer> current=all_customers.gethead();
        Customer cust=null;
        while(current!=null){
             cust=current.data;
             if(cust.getId()==id)
             break;
             current=current.next;
        }

        if(current==null){
            System.out.println("ENTER CORRECT ID");
            return;
        }

        //now current node is at customer desired selected node
        //and cust object is also having ref to customer
        cust.Update_Details();//can also do current.data.Update_Details();
    }


    public void delete_customer(){
         if(all_customers.gethead()==null){
            System.out.println("NO CUSTOMERS YET");
            return;
        }
        show_All_Customers();
        System.out.println("Enter id of which customer you want to remove");
        int id=input.nextInt();
        Node<Customer> current=all_customers.gethead();
        Customer cust=null;
        while(current!=null){
             cust=current.data;
             if(cust.getId()==id)
             break;
             current=current.next;
        }

        if(current==null){
            System.out.println("ENTER CORRECT ID");
            return;
        }

        //now we just have to remove current node from customer List
        all_customers.removeFirst(current.data);
        System.out.println("Successfully Removed");
        

    }






    public void RENT_A_VIDEO(Customer c){
        print_all_videos();
        System.out.println("Hello "+c.name+", TO RENT A VIDEO ENTER IT'S ID");
        int id=input.nextInt();
        Node<Video> current=vids.gethead();

        if(current==null){ //means head empty
         System.out.println("EMPTY LIST");
         return;
        }

        while (current!=null) {
            Video temp=current.data;
            if(temp.ID==id && temp.status.equalsIgnoreCase("available")){
                break;
            }
            else if(temp.ID==id && !temp.status.equalsIgnoreCase("available")){
              System.out.println("NOT AVAILABLE");
              return;
            }

            current=current.next;   
        }

        if(current==null){//reached end of list 
         System.out.println("NOT FOUND");
         return;
        }

        //now current has same referance as of searched,available video
        //do note current is node while current.data is video
       current.data.setStatus("unavailable");
       Node<Customer> temp_cust=all_customers.find(c);
       if(temp_cust!=null){//customer exists in database
        temp_cust.data.add_Rented_video(current.data);
        System.out.println("SUCCESSFULLY RENTED");
       }
       else{
        c.add_Rented_video(current.data);
        System.out.println("SUCCESSFULLY RENTED");
        addCustomer(c);
       }
    }

    public void RETURN_VIDEO(Customer c){
        if(c.getRented_vids().gethead()==null){
             System.out.println("Customer desnt have any books on rent");
            return;
        }
        
        Node<Customer> temp=all_customers.find(c); //to catch ref we have to do this
        if(temp.data.rented_vids==null){
            System.out.println("This customer has no books rented");
            return;
        }
        System.out.println(temp.data.toString());
        System.out.println("Enter ID of movie to return");
        int id=input.nextInt();
        Node<Video> vid_to_ret=temp.data.get_rented_video_byid(id);
        vid_to_ret.data.setStatus("Available");
        temp.data.remove_rented_video(vid_to_ret.data);
        System.out.println("VIDEO RETURNED SUCCESSFULLY");
        
    }


    public void show_Details_of_video_With_ID(int id){
        if(vids.gethead()==null){
         System.out.println("NO VIDEOS in stock");
         return ;
        }

        Node<Video> current=vids.gethead();
        Video temp=null;;
        while(current!=null){
            temp=current.data;
            if(temp.getID()==id){
                break;
            }
            current=current.next;
        }

        if(current==null){
            System.out.println("NOT FOUND");
            return;
        }

        //now my current is at my desired video
        //and at temp my desired video is there
        System.out.println(temp.toString());
        

    }


    public void print_all_videos(){
         if(vids.gethead()==null){
         System.out.println("NO VIDEOS in stock");
         return ;
        }
        System.out.println();
        vids.print();
    }

    public boolean check_for_video(int id){
        if(vids.gethead()==null){
         System.out.println("NO VIDEOS in stock");
         return false ;
        }

        Node<Video> current=vids.gethead();
        Video temp=null;;
        while(current!=null){
            temp=current.data;
            if(temp.getID()==id && temp.getStatus().equalsIgnoreCase("available")  ){
                System.out.println("YES VIDEO AVAILABLE");
                return true;
            }
            current=current.next;
        }

       System.out.println("NOPES, VIDEO NOT AVAILABLE");
       return false;

    }

        
}
    

