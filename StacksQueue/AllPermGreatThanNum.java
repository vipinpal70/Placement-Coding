package StacksQueue;

import java.util.Stack;

/*
 * Count natural numbers whose all permutation are greater than that number
 */
public class AllPermGreatThanNum {
    public static int AllPermGreatThanNumber(int num) {
        int ans = 0;
        int unitD = 0, uTan = 0;
        if (num > 11) {
            ans = 10;

            for (int i = 12; i <= num; i++) {
                unitD = i % 10; // 2
                int n = i / 10;
                if (n > 9) {
                    uTan = i % 10;
                } else {
                    uTan = n;
                }
                if (unitD >= uTan && unitD != 0  ) {
                    ans++;
                }
            }
        } else {
            return num != 10 ? num : 9;
        }

        System.out.println("ans: " + ans);
        return ans;
    }


    static int countNumber(int n) {
        int result = 0;

        // Pushing 1 to 9 because all number from 1
        // to 9 have this property.
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i <= 9; i++) {

            if (i <= n) {
                s.push(i);
                result++;
            }

            // take a number from stack and add
            // a digit greater than or equal to last digit
            // of it.
          
            while (!s.empty()) {
                int tp = s.pop();
  

                for (int j = tp % 10; j <= 9; j++) {
                    int x = tp * 10 + j;
                    
                    if (x <= n) {
                        s.push(x);
                        result++;
                    }
                }
            }
        }

        System.out.println("result: " + result);
        return result;
    }

    public static void main(String[] args) {
        int num = 100;
        // AllPermGreatThanNumber(num);
        // AllPermGreatThanNumber(15);
        countNumber(num);
        countNumber(15);
    }
}
