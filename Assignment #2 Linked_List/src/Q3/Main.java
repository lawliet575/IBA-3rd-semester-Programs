package Q3;

public class Main {
    public static void main(String[] args) {
        Store naheed=new Store();


        //ADD VIDEOS TO STORE
        Video v1=new Video("Harry-Potter", 248);
        Video v2=new Video("Ben 10", 535);
        Video v3=new Video("Demon-Slayer", 746);
        Video v4=new Video("DBZ", 867);
        Video v5=new Video("El-Classico", 124);
        naheed.addvideo(v1);
        naheed.addvideo(v2);
        naheed.addvideo(v3);
        naheed.addvideo(v4);
        naheed.addvideo(v5);


       //ADD SOME CUSTOMERS
        Customer c1=new Customer("Ikhlas", 6457);
        Customer c2=new Customer("Atiq", 4751);
        Customer c3=new Customer("Saad", 4575);
        naheed.addCustomer(c1);
        naheed.addCustomer(c2);
        naheed.addCustomer(c3);

        //RENTING
         /*
        naheed.RENT_A_VIDEO(c1);
        naheed.RENT_A_VIDEO(c1);
        naheed.RENT_A_VIDEO(c2);
        naheed.RENT_A_VIDEO(c2);
        naheed.RETURN_VIDEO(c1);
        naheed.print_all_videos();
        naheed.show_All_Customers();
         */

        //show details of particular VIDEO
          //naheed.show_Details_of_video_With_ID(124);

        //Print all videos in store
          //naheed.print_all_videos();

        //check whether a video exists in store
          //naheed.check_for_video(535);

        //UPDATING CUSTOMER RECORD
          //naheed.updateCustomer_record();
          //naheed.show_All_Customers();

        //Deleting Customer record
           //naheed.delete_customer();
           //naheed.show_All_Customers();
    }
    
    
}
