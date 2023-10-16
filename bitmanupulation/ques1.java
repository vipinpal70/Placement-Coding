package bitmanupulation;

// check if a number id Odd or Even
public class ques1 {
    public static void main(String[] args) {
        int num = 14;
        if ((num & 1) == 0) {
            System.out.println(num + " is Even");
        } else {
            System.out.println(num + " is Odd");
        }
    }
}
