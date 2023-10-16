public class removeWhiteSpace {    


    public static void rep(String str){
        StringBuilder  ss = new StringBuilder();
        int index = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == ' '){
                ss.append(str.substring(index, i));
                index = i;

            }
        }
        System.out.println(ss);
        
    }
    public static void main(String[] args) {    
            
        String str1="Remove white spaces"; 
           
            
        // str1 = str1.replaceAll("\\s+", "");
        rep(str1);    
            
        // System.out.println("String after removing all the white spaces : " + str1);    
    }    
}

// write a pro that greeks a user based on the current time and pro don't take input 
// if current time is 12 pm to 6 pm   --> 