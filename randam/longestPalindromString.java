// Longest Palindromic Substring by Manacher's algorithm
public class longestPalindromString {
    public static boolean isPalindrome(String s) {
        s.toLowerCase();
        if (s.length() < 2)
            return true;
        if (s.charAt(0) == s.charAt(s.length() - 1)) // Recursive portion.
        {
            s = s.substring(1, s.length() - 1);
            if (isPalindrome(s))
                return true;
            else
                return false;
        } else
            return false;
    }

    public static int value(String subs) {
        int mx = 0;
        if (subs.length() > mx) {
            mx = subs.length();
        }
        return mx;
    }

    public static void main(String[] args) {
        String str = "ravi1221kumar";
        if (isPalindrome(str)) {
            System.out.println("str: " + str);
            System.out.println(str.length());
            return;
        }
        int fn = 0;
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            String subs;
            for (int j = i; j <= str.length(); j++) {
                subs = str.substring(i, j);
                if (isPalindrome(subs)) {
                    if (subs.length() > result.length()) {
                        result = subs;
                        fn = value(result);
                    }
                }
            }
        }
        System.out.println(result);
        System.out.println(fn);
    }
}

// 123321  
