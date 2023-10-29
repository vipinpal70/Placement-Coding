package backtracking;

import java.util.HashMap;

public class CryptarithmeticPuzzles {

    public static int getNum(String str, HashMap<Character, Integer> map) {
        String nn = "";
        for (int i = 0; i < str.length(); i++) {
            nn += map.get(str.charAt(i));
        }
        return Integer.parseInt(nn);

    }

    public static void SolvingCryptarithmeticPuzzles(String unique, int ind, HashMap<Character, Integer> map,
            boolean[] useNumbers, String str1, String str2, String str3) {

        // base case

        if (ind == unique.length()) {
            int num1 = getNum(str1, map);
            int num2 = getNum(str2, map);
            int num3 = getNum(str3, map);

            if (num1 + num2 == num3) {
                // for print into alphabetical order
                for (int i = 0; i < 26; i++) {
                    char ch = (char) ('a' + i);
                    if (map.containsKey(ch)) {
                        System.out.print(ch + "-" + map.get(ch) + " ");
                    }
                }
                System.out.println();
            }
            return;

        }

        // recursive step
        char c = unique.charAt(ind);
        for (int i = 0; i <= 9; i++) {
            if (useNumbers[i] == false) {
                map.put(c, i);
                useNumbers[i] = true;
                SolvingCryptarithmeticPuzzles(unique, ind + 1, map, useNumbers, str1, str2, str3);
                useNumbers[i] = false;
                map.put(c, -1);

            }
        }
    }

    public static void main(String[] args) {
        String str1 = "send";
        String str2 = "more";
        String str3 = "money";
        String combination = str1 + str2 + str3;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        String unique = "";
        for (int i = 0; i < combination.length(); i++) {
            char c = combination.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, -1);
                unique += c;
            }
        }

        boolean[] useNumbers = new boolean[10];

        // System.out.println(unique);
        System.out.println();
        System.out.println();
        SolvingCryptarithmeticPuzzles(unique, 0, map, useNumbers, str1, str2, str3);
        System.out.println();
        System.out.println();
    }
}
