package string;

public class palindrone {
    public static boolean checkPalindrone(String str) {
        int start = 0, last = str.length() - 1;
        while (start < last) {
            if (str.charAt(start) == str.charAt(last)) {
                start++;
                last--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "vipin";
        System.out.println(checkPalindrone(str));
    }
}
