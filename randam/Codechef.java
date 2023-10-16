 

import java.util.*;


 
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner s = new Scanner(System.in);
        String re = "";
		int t = s.nextInt();
        
        Stack <String> stk = new Stack<>();  
        
		while(t > 0){
		    String str = s.nextLine();
		    for (int i =0;i<str.length();i++ ) {
		        char ch = str.charAt(i);
                if(ch=='('){
                    stk.push(String.valueOf(ch));
                }
                if(ch>=98 && ch<=122){
                    stk.push(String.valueOf(ch));
                }
                if(ch=='+'|| ch=='-'|| ch=='*'|| ch=='/'|| ch=='^'){
                    stk.push(String.valueOf(ch));
                }
                if(ch==')'){
                    String a = stk.pop();  //  c
                    String op = stk.pop();  // *
                    String b = stk.pop();  // b
                    String sy = stk.pop();  // (
                        System.out.println("sy: " + sy);
                    re = re+b+a+op;
                    stk.push(re);

                }
                
		    }

		    System.out.println(re);
		    t--;
		}
        s.close();
	}
}

