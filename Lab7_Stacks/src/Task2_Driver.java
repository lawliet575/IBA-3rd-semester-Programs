public class Task2_Driver {
    public static void main(String[] args) {

        //INFIX TO POSTFIX EVALUATION CAN ENTER ANY NUMBER OF VAR.
        String str="[(A+B)/B+A-C+(B-C)]";
        System.out.println(infix_to_postfixmyString(str));


       //POSTFIX EVALUATION ENTER ANY EQUATION
        System.out.println(Postifix_eval("32+2/3+1-23-+")); 
        
    }

     
      public static int Postifix_eval(String str){
        LinkedList_Stack<Character> st=new LinkedList_Stack<>();

        for (int i = 0; i <str.length(); i++) {
            char ch=str.charAt(i);

            //CASE 1 NUMBERS 0-9
            if(ch>='0' && ch<='9'){ //NUMBERS ARE DIRECTLY PUSHED INTO STACK
                st.push(ch);
            }

            //CASE 2 FOR OPERATIONS + - * /
            else {
                if(ch=='+'){
                    //before storing convert char to int
                    int s1=st.pop()-'0';
                    int s2=st.pop()-'0';
                    //result
                    int temp=s1+s2;
                    //convert back to char
                    char res=(char)temp;
                    res+='0';
                    
                    //push back in stack
                    st.push(res);
                }
                else if(ch=='-'){
                    //before storing convert char to int
                    int s1=st.pop()-'0';
                    int s2=st.pop()-'0';
                    //result
                    int temp=s2-s1;
                    //convert back to char
                    char res=(char)temp;
                    res+='0';
                    
                    //push back in stack
                    st.push(res);
                    
                }
                else if(ch=='*'){
                    //before storing convert char to int
                    int s1=st.pop()-'0';
                    int s2=st.pop()-'0';
                    //result
                    int temp=s1*s2;
                    //convert back to char
                    char res=(char)temp;
                    res+='0';
                    
                    //push back in stack
                    st.push(res);
                    
                }
                else if(ch=='/'){
                    //before storing convert char to int
                    int s1=st.pop()-'0';
                    int s2=st.pop()-'0';
                    //result
                    int temp=s2/s1;
                    //convert back to char
                    char res=(char)temp;
                    res+='0';
                    
                    //push back in stack
                    st.push(res);
                }
                
            }
        } //for loop ends

        int final_Res=st.pop()-'0';
        return final_Res;

            
    }
        

    
    public static String infix_to_postfixmyString(String str){
        Array_Stack<Character> st=new Array_Stack<>(str.length());
        String result="";

        for (int i = 0; i <str.length(); i++) {
             char ch=str.charAt(i);

             //for letters
             if(ch>='A' && ch<='Z'){
              result+=ch;
             }

            //for opening brackets
             else if(ch== '(' || ch=='[' || ch=='{'){ //left parenthesis direct pushed
                st.push(ch);
             }

             // closing brackets pr pop and add in output until opening na ajaye
             else if(ch== '+' || ch=='-' || ch=='*' || ch=='/'){
                //now check if empty so add directly to stack
                if(st.isEmpty()){
                  st.push(ch);
                }

                //agar elements ho to check if incoming has higher precedance than peek 

                else if(ch=='+'){ //since + and - are same so dono ko or krke bhe krskte thay
                    while(!st.isEmpty() && st.peek()!='(' && st.peek()!='[' && st.peek()!='{'){
                        //pop all until + se choti precedence na ajaye
                        char temp=st.pop(); //add in output
                        result=result+temp;
                        
                    }
                    st.push(ch);
                }

                else if(ch=='-'){
                    while(!st.isEmpty() && st.peek()!='(' && st.peek()!='[' && st.peek()!='{'){
                        //pop all until + se choti precedence na ajaye
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.push(ch);
                }

                else  if(ch=='*') { //since * and / are same so dono ko or krke bhe krskte thay

                    while(!st.isEmpty() && st.peek()!='(' && st.peek()!='[' && st.peek()!='{' && st.peek()!='+' && st.peek()!='-'){
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.push(ch);
                }

                else  if(ch=='/') {

                    while(!st.isEmpty() && st.peek()!='(' && st.peek()!='[' && st.peek()!='{'  && st.peek()!='+'  && st.peek()!='-'  ){
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.push(ch);
                }

             } //+ - * / ke cases ends here

             //now coming towards closing brackets
             else if(ch== ')' || ch=='}' || ch==']'){
                //pop until similar opeing comes and add in output
                //do remove opening at end
                if(ch==')'){ //pop until ( and also pop (
                    while(st.peek()!='('){
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.pop();//dont add in output

                }
                else if(ch==']'){
                    while(st.peek()!='['){
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.pop();//dont add in output
                    
                }
                else if(ch=='}'){
                    while(st.peek()!='{'){
                        char temp=st.pop(); //add in output
                        result=result+temp;
                    }
                    st.pop();//dont add in output
                    
                }
             }

            } //for loop end

           //CHECK FOR ANY REMAINING ELEMENTS IN STACK
            if(st.isEmpty()){
                return result;
            }
            else {
                while(!st.isEmpty()){
                    char temp=st.pop(); //add in output
                    result=result+temp;
                }

                return result;
            }

        
       

        }

    
    


}


