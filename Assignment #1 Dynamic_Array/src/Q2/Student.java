package Q2;

class Student implements Comparable <Student> {
    String name;
    int age;
    int id;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }



    @Override
    public String toString() {
        return "Name: "+name+"\n"+
                "Age: "+age+"\n"+
                "ID: "+id+"\n";
    }

    @Override
    public int compareTo(Student student) {
        if(this.age<student.age) //passed obj bara
            return -1;
        else if(this.age>student.age){ //passed obj chota
            return 1;
        }
        else return 0; //both equal
    }


}
