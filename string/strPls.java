package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*
 * Placement related question 
 */
public class strPls {

    // lowercase characters count
    public static void lowercaseCharacters(String str) {
        int cn = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                cn++;
            }
        }
        System.out.println(cn);

    }

    // Palindrome
    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int start = 0, last = s.length() - 1;

        while (start <= last) {
            char currFirst = s.charAt(start);
            char currLast = s.charAt(last);

            if (!Character.isLetterOrDigit(currFirst)) {
                start++;
            } else if (!Character.isLetterOrDigit(currLast)) {
                last--;
            } else {
                if (Character.toLowerCase(currFirst) != Character.toLowerCase(currLast)) {
                    return false;
                }
                start++;
                last--;
            }
        }
        return true;
    }

    // valid Anagram
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] char_counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char_counts[s.charAt(i) - 'a']++;
            char_counts[t.charAt(i) - 'a']--;
        }
        for (int count : char_counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;

    }

    // Valid Parentheses
    public static boolean validParentheses(String str) {
        if (str.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if ((ch == '(' && top == ')') || (ch == '{' && top == '}') || (ch == '[' && top == '[')) {
                        stack.pop();
                    }

                }
            }
        }
        return true;

    }

    // Remove consecutive characters
    // ----- Using recursive Approach
    public static void removeConsecutiveChar(String str, int i, char ch, String ans) {
        // base case
        if (str.length() == i) {
            System.out.println(ans);
            return;
        }
        // kaam
        if (ch == str.charAt(i)) {
            removeConsecutiveChar(str, i + 1, str.charAt(i), ans);
        } else {
            ans = ans + str.charAt(i);
            removeConsecutiveChar(str, i + 1, str.charAt(i), ans);
        }
    }

    // ----- using loop Approach
    public static void removeConsectCharacter(String str) {
        char ch = str.charAt(0);
        String ans = "" + ch;
        for (int i = 1; i < str.length(); i++) {
            if (ch != str.charAt(i)) {
                ans = ans + str.charAt(i);
                ch = str.charAt(i);
            }
        }
        System.out.println(ans);
    }

    // Longest Common prfix
    // ---- Using recursion Approach
    public static void longestCommonPrefix(String arr[], String ans, int i) {
        // base case
        if (i == arr[0].length()) {
            System.out.println(ans);
            return;
        }

        // kaam
        char ch = arr[0].charAt(i);
        for (int j = 0; j < arr.length; j++) {
            if ((arr[j].length() > i)) {
                if (ch != arr[j].charAt(i)) {
                    System.out.println(ans);
                    return;
                }
            } else {
                System.out.println(ans);
                return;
            }
        }
        ans = ans + ch;
        longestCommonPrefix(arr, ans, i + 1);
    }

    // ---- Using for loop Approach
    public static String longestComPrefix(String[] strs) {
        int N = strs[0].length();
        String ans = "";
        for (int i = 0; i < N; i++) {
            int index = 0;
            while (index < strs.length - 1) {
                if (strs[index].length() > i && strs[index + 1].length() > i) {
                    if ((strs[index].charAt(i) != strs[index + 1].charAt(i))) {
                        return ans;
                    }
                } else {
                    return ans;
                }
                index++;
            }
            ans = ans + strs[0].charAt(i);
        }
        return ans;

    }

    // best Approach
    public String longestCommonPrefixBest(String[] strs) {

        if (strs.length == 0)
            return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    // Convert a sentence into its equivalent mobile numeric keypad sequence
    public static void equivalentMobile(String inp) {
        String[] map = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7",
                "77", "777", "8", "88", "888", "9", "99", "999", "9999" };

        inp = inp.toLowerCase();
        for (char str : inp.toCharArray()) {
            if (str == ' ') {
                System.out.print("0");
            } else {

                System.out.print(map[str - 'a']);
            }
        }
        System.out.println("");
    }

    // Print all the duplicate characters in a string
    public static void duplicateCharacters(String str) {
        int[] map = new int[26];
        String alphabets = "abcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map[ch - 'a']++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] != 0) {
                System.out.print(alphabets.charAt(i) + ": " + map[i]);
                System.out.println("");
            }
        }
    }

    // group Anagram List<List<String>> this work only if there is no empty string
    // A normal Approach
    public static void groupAnagrams(String[] strs) {

        ArrayList<List<String>> finalList = new ArrayList<List<String>>();

        for (int i = 0; i < strs.length; i++) {
            ArrayList<String> group = new ArrayList<>();
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            String checkString = new String(array);

            if (!checkString.isEmpty()) {
                group.add(strs[i]);

                for (int j = i + 1; j < strs.length; j++) {
                    char[] arrayNext = strs[j].toCharArray();
                    Arrays.sort(arrayNext);
                    String checkNext = new String(arrayNext);

                    if (checkString.equals(checkNext) && !checkNext.isEmpty()) {
                        group.add(strs[j]);
                        strs[j] = "";
                    }
                }
            }

            if (!group.isEmpty()) {
                finalList.add(group);
            }
        }
        System.out.println(finalList);
        // return finalList;
    }

    // hashMap Approach
    public static List<List<String>> groupAnagramsBest(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String word : strs) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String checkString = new String(charArray);

            if (!map.containsKey(checkString)) {
                map.put(checkString, new ArrayList<>());
            }

            map.get(checkString).add(word);
        }
        return new ArrayList<>(map.values());
    }

    // lonest Palindrome A Noormal Appraoch
    public static String longestPalindrome(String s) {
        int st = 0, lt = 0, ln = 0;
        if (s.length() <= 1)
            return s;

        String check = "";
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            for (int j = s.length() - 1; j > i; j--) {
                if (ch == s.charAt(j)) {
                    check = s.substring(i, j + 1);
                    if (isPalindrome(check)) {
                        if (ln < check.length()) {
                            ln = check.length();
                            st = i;
                            lt = j + 1;
                        }
                    }

                }
            }
        }
        if (lt != 0) {

            return s.substring(st, lt);
        }
        return s.substring(st, lt + 1);

    }

    // best Approach
    public static String longestPalindromeBest(String s) {
        if (s == null || s.length() < 1)
            return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandFromMiddle(s, i, i);
            int len2 = expandFromMiddle(s, i, i + 1);
            int length = Math.max(len1, len2);

            if (length > end - start) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        return s.substring(start, end + 1);

    }

    // A way of checking palindrome from the center Approach
    public static int expandFromMiddle(String s, int left, int right) {
        if (s == null || left > right)
            return 0;
        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    // Palindrome substring
    public static void palindromeSubstring(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        int count = 0;
        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; i++, j++) {
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    if (s.charAt(i) == s.charAt(j)) {

                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1] == true) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    // Smallest window in a string containing all the characters of another string

    public static String smallestWindow(String s, String p) {
        String ans = "";
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        int mct = 0, dmct = p.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        int i = -1, j = -1;
        while (true) {
            // acquire
            boolean f1 = false, f2 = false;
            while (i < s.length() - 1 && mct < dmct) {
                i++;
                char ch = s.charAt(i);
                map1.put(ch, map1.getOrDefault(ch, 0) + 1);

                if (map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
                    mct++;
                }
                f1 = true;
            }
            // release and count

            while (j < i && mct == dmct) {
                String pans = s.substring(j + 1, i + 1);
                if (ans.length() == 0 || pans.length() < ans.length()) {
                    ans = pans;
                }
                j++;
                char ch = s.charAt(j);
                if (map1.get(ch) == 1) {
                    map1.remove(ch);
                } else {
                    map1.put(ch, map1.get(ch) - 1);
                }

                if (map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
                    mct--;
                }
                f2 = true;
            }

            if (f1 == false && f2 == false) {
                break;
            }
        }

        return ans;
    }

    // Wildcard string matching ---------------- Good Question

    public static boolean wildcardMatching(String str, String p) {

        boolean[][] dp = new boolean[p.length() + 1][str.length() + 1];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = true;
                } else if (i == dp.length - 1) {
                    dp[i][j] = false;
                } else if (j == dp[0].length - 1) {
                    if (p.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j];
                    } else {
                        dp[i][j] = false;
                    }
                } else {
                    if (p.charAt(i) == '?') {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else if (p.charAt(i) == '*') {
                        dp[i][j] = dp[i + 1][j] || dp[i][j + 1];
                    } else if (p.charAt(i) == str.charAt(i)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        return dp[0][0];
    }

    // Longest Prefix Suffix
    public static int longestPrefixSuffix(String s) {
        int ans = 0;
        for (int i = 1; i < s.length(); i++) {
            String str1 = s.substring(0, i);
            String str2 = s.substring(s.length() - i);

            if (str1.equalsIgnoreCase(str2)) {
                ans = Math.max(ans, str1.length());

            }
        }
        return ans;
    }

    // Rabin-Karp Algorithm for Pattern Searching
    public static void rabinKarp(String pat, String txt, int q) {

        final int d = 256;

        int M = pat.length();
        int N = txt.length();
        int i, j;
        int p = 0; // hash value for pattern
        int t = 0; // hash value for txt
        int h = 1;

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first
        // window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of
            // text and pattern. If the hash values match
            // then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j))
                        break;
                }

                // if p == t and pat[0...M-1] = txt[i, i+1,
                // ...i+M-1]
                if (j == M)
                    System.out.println(
                            "Pattern found at index " + i);
            }

            // Calculate hash value for next window of text:
            // Remove leading digit, add trailing digit
            if (i < N - M) {
                t = (d * (t - txt.charAt(i) * h)
                        + txt.charAt(i + M))
                        % q;

                // We might get negative value of t,
                // converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

    }

    // Transform One String to Another using Minimum Number of Given Operation

    public static int TransformOneStrToAnother(String A, String B) {
        if (A.length() != B.length())
            return -1;

        HashMap<Character, Integer> map = new HashMap<>();
        // first check both string have same characters
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < B.length(); i++) {
            char ch2 = B.charAt(i);
            if (map.containsKey(ch2))
                map.put(ch2, map.get(B.charAt(i)) - 1);
        }
        // checking character frequencies are equal or not
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return -1;
        }

        // Start tranfer from ending side and put in the front
        int i = A.length() - 1, j = B.length() - 1;
        int res = 0;
        while (i >= 0 && j >= 0) {
            while (i >= 0 && A.charAt(i) != B.charAt(j)) {
                res++;
                i--;
            }
            i--;
            j--;
        }
        return res;

    }


    
    public static void main(String[] args) {
        // lowercaseCharacters("My Name");

        // String c = "A man, a plan, a canal: Panama";
        // String c = "(){}[]";
        // System.out.println(validParentheses(c));

        // String str = "aaabbccdddddd";
        // removeConsecutiveChar(str, 0, '~', "");
        // removeConsectCharacter(str);

        // String str[] = { "flower", "flow", "flight" };
        // String str[] = { "dog", "racecar", "car" };
        // String str[] = { "ab", "a" };
        // String str[] = { "flower", "flower", "flower", "flower" };
        // longestCommonPrefix(str, "", 0);
        // System.out.println(longestComPrefix(str));

        // String inp = "HELLO WORLD";
        // equivalentMobile(inp);

        // duplicateCharacters("geeksforgeeks");

        // String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        // groupAnagrams(strs);
        // System.out.println(groupAnagramsBest(strs));

        // String s = "aacabdkacaa";
        // String s = "xaabacxcabaaxcabaax";
        // String s = "xaabacxcabaax";
        // System.out.println(isPalindrome(s));
        // String s = "aacabdkacaa";
        // System.out.println(longestPalindromeBest(s));

        // String s = "aaa";
        // String s = "abccd";
        // palindromeSubstring(s);

        // String S = "timetopractice";
        // String P = "toc";
        // String S = "zoomlazapzo";
        // String P = "oza";
        String S = "ADOBECODEBANC";
        String P = "ABC";
        String ans = smallestWindow(S, P);
        System.out.println("ans: " + ans);

        // String pattern = "ge*ks";
        // String wild = "geeks";
        // String pattern = "ba*a?";
        // String wild = "baaabab";
        // String pattern = "ge?ks*";
        // String wild = "geeksforgeeks";
        // System.out.println(wildcardMatching(pattern, wild));

        // String str = "abab";
        // String str = "aaaa";
        // System.out.println(longestPrefixSuffix(str));

        // String txt = "GEEKS FOR GEEKS";
        // String pat = "GEEK";
        // // A prime number
        // int q = 101;
        // // Function Call
        // rabinKarp(pat, txt, q);

        // String A = "ABD", B = "BAD";
        // int operation = TransformOneStrToAnother(A, B);
        // System.out.println("operation: " + operation);

    }
}
