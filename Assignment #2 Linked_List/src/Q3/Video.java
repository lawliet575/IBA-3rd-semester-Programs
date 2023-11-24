package Q3;

public class Video implements Comparable<Video> {
    String title;
    int ID;
    String status;


    public Video(String title, int iD) {
        this.title = title;
        ID = iD;
        status="available";

    }

    

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }



    public int getID() {
        return ID;
    }



    public void setID(int iD) {
        ID = iD;
    }



    public String getStatus() {
        return status;
    }



    public void setStatus(String status) {
        this.status = status;
    }



    @Override
    public String toString() {
        return " Video [title=" + title + ", ID=" + ID + ", status=" + status + " ] ";
    }


    @Override
    public int compareTo(Video v) { //searching 
        if(this.ID>v.ID)
        return 1;

        if(this.ID<v.ID)
        return -1;

        return 0;
        
    }
    
}
