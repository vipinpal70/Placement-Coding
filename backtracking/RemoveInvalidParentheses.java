package backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RemoveInvalidParentheses {
    public static void RemoveInvalidParen(String str) {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        if (equalBrackets(str)) {
            if (isValidParentheses(str)) {
                map.put(-1, str);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == ')') {
                String temp = str.substring(0, i) + str.substring(i + 1);
                System.out.println(temp);
                if (equalBrackets(temp)) {
                    if (isValidParentheses(temp)) {
                        if (!map.containsValue(temp)) {
                            map.put(i, temp);
                        }
                    }
                }
            }
        }

        for (Map.Entry<Integer, String> mapElement : map.entrySet()) {
            // Integer key = mapElement.getKey();

            // Adding some bonus marks to all the students
            String value = (mapElement.getValue());

            // Printing above marks corresponding to
            // students names
            System.out.println("--> " + value);
        }
    }

    public static boolean equalBrackets(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                count++;
            }
            if (str.charAt(i) == ')') {
                count--;
            }
        }
        if (count == 0)
            return true;
        else
            return false;
    }

    public static boolean isValidParentheses(String str) {
        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {

            if (ch == '(' || ch == ')') {

                if (ch == '(') {
                    stack.push(ch);
                } else {
                }
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.peek();
                    if (ch == ')' && top == '(') {
                        stack.pop();
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String pr = "()())()";
        // String pr = "(v)())()";
        // String pr = "()v)";
        RemoveInvalidParen(pr);
    }
}
 