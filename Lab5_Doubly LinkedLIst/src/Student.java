class Student implements Comparable <Student> {
    String name;
    int age;
    int ID;

    public Student(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.ID = id;
    }



    @Override
    public String toString() {
        return "Name: "+name+"\n"+
                "Age: "+age+"\n"+
                "ID: "+ID+"\n";
    }

    @Override
    public int compareTo(Student student) {
        if(ID>student.ID)
            return 1;
        else if(ID<student.ID)
            return -1;

            return 0;
    }


}
