class Student implements Comparable <Student> {
    String name;
    int age;
    double cgpa;

    public Student(String name, int age, double cgpa) {
        this.name = name;
        this.age = age;
        this.cgpa = cgpa;
    }



    @Override
    public String toString() {
        return "Name: "+name+"\n"+
                "Age: "+age+"\n"+
                "CGPA: "+cgpa+"\n";
    }

    @Override
    public int compareTo(Student student) {
        if(student.cgpa>this.cgpa)
            return 1;
        else return -1;
    }


}
