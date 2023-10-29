package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticExpressions {
    public static void ArithmeticExpMethod(int[] num, String opt, int idx, int ans, List<String> result) {

        // base case
        if (idx == num.length) {
            if (ans % 101 == 0) {
                for (int i = 0; i < result.size(); i++) {
                    System.out.print(result.get(i));
                }
                return;
            }
            return;
        }

        // recusion step
        int local = num[idx]; // 3
        for (int i = 0; i < opt.length(); i++) {
            char c = opt.charAt(i);
            if (c == 'x') {
                ans = ans * local;
                result.add("x " + local);
                ArithmeticExpMethod(num, opt, idx + 1, ans, result);
                ans = ans / local;
                result.remove(result.size() - 1);
            }
            if (c == '+') {
                ans = ans + local;
                result.add("+ " + local);
                ArithmeticExpMethod(num, opt, idx + 1, ans, result);
                ans = ans - local;
                result.remove(result.size() - 1);
            }
            if (c == '-') {
                ans = ans - local;
                result.add("- " + local);
                ArithmeticExpMethod(num, opt, idx + 1, ans, result);
                ans = ans + local;
                result.remove(result.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = { 55, 3, 45, 25, 33 };
        String operator = "+-x";
        ArrayList<String> result = new ArrayList<String>();
        result.add("" + numbers[0]);
        ArithmeticExpMethod(numbers, operator, 1, numbers[0], result);
    }
}


