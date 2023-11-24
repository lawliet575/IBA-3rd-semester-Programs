public class Myprinter implements Comparable <Myprinter> {
    String name;
    int priority;


    public Myprinter(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int compareTo(Myprinter p) {
        if(this.priority>p.getPriority()){
            return 1;
        }
        else if(this.priority<p.getPriority()){
            return -1;
        }
        else{ //both priorities are now equal
            return -1; //fifo now 
    
        }
        
    }

    @Override
    public String toString() {
        return getName();
    }

    



    
    
}
