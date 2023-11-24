public class Driver {
    public static void main(String[] args) {
        MyArraylist list = new MyArraylist();
        list.Add("hello");
        list.Add(3);
        list.Add(4);
        list.Add(5);
        list.Add(6);
        list.Add(7);
        list.Add(8);
        list.Add(9);
        list.Remove(9);
        System.out.println(list.toString());
        //System.out.println(list.Find("hello"));
       //list.clear();
        //System.out.println(list.toString());
        //list.Update(0,3);
        //System.out.println(list.toString());

        MyArraylist<Student> studentlist=new MyArraylist<Student>();
        Student s1=new Student("Ikhlas",20,3.1);
        Student s2=new Student("Dave",18,3.5);
        Student s3=new Student("Alvin",26,2.5);
        studentlist.Add(s1);
        studentlist.Add(s2);
        studentlist.Add(s3);

        System.out.println(studentlist.Find(s1));
        System.out.println(studentlist.get(0));
        System.out.println(studentlist.FindMax());

        


        }







    }

