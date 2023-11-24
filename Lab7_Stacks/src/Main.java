public class Main {

    public static void main(String[] args) {
        /* 
         Array_Stack st=new Array_Stack<>(4);
         st.push(2);
         st.push(4);
         st.push(6);
         st.push(8);
         st.print();
         st.pop();
         st.print(); 
         */

        /* 
         LinkedList_Stack ls=new LinkedList_Stack<>();
         ls.push(3);
         ls.push(6);
         ls.push(9);
         ls.print_stack();
         System.out.println(ls.pop());
         ls.print_stack();  
         */

         String st="{{{}}}";
         System.out.println(validate(st));
         
    }


    public static Boolean validate(String str){
        Array_Stack<Character> s=new Array_Stack<>(str.length());
        for (int i = 0; i <str.length(); i++) {
             char ch=str.charAt(i);
             if(ch== '(' || ch=='[' || ch=='{'){
                s.push(ch); //opening saare pushed
             }

             else{
                if(s.isEmpty()){
                    return false;
                }

                if( s.peek()=='(' && ch==')' || s.peek()=='{' && ch=='}' || s.peek()=='[' && ch==']'){
                    s.pop();
                }
                else {
                    return false;
                }
             }

        }
            

        if(s.isEmpty()){
            return true; //all valid parenthesis
        }
        else return false;
    }
    
    
}
