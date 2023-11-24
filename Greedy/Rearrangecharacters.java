package Greedy;

import java.util.*;

// Java program to rearrange characters in a string so that no two adjacent characters are same.

class KeyComparator implements Comparator<Key> {

    // Overriding compare()method of Comparator
    public int compare(Key k1, Key k2) {
        if (k1.freq < k2.freq)
            return 1;
        else if (k1.freq > k2.freq)
            return -1;
        return 0;
    }
}

class Key {

    int freq; // store frequency of character
    char ch;

    Key(int val, char c) {
        freq = val;
        ch = c;
    }
}

class Rearrangecharacters {
    static int MAX_CHAR = 26;

    static void rearrangeString(String str) {
        int n = str.length();

        // Store frequencies of all characters in string
        int[] count = new int[MAX_CHAR];

        for (int i = 0; i < n; i++)
            count[str.charAt(i) - 'a']++;

        // Insert all characters with their frequencies into a priority_queue
        PriorityQueue<Key> pq = new PriorityQueue<>(new KeyComparator());
        for (char c = 'a'; c <= 'z'; c++) {
            int val = c - 'a';
            if (count[val] > 0)
                pq.add(new Key(count[val], c));
        }

       
        str = "";

        // work as the previous visited element initial previous element be. ( '#' and
        // it's frequency '-1' )
        Key prev = new Key(-1, '#');

     
        while (pq.size() != 0) {

            
            Key k = pq.peek();
            pq.poll();
            str = str + k.ch;

            // If frequency of previous character is less than zero that means it is
            // useless, we need not to push it
            if (prev.freq > 0)
                pq.add(prev);

            // make current character as the previous 'char' decrease frequency by 'one'
            (k.freq)--;
            prev = k;
        }

        if (n != str.length())
            System.out.println(" Not possible ");
        else
            System.out.println(str);
    }

    public static void main(String args[]) {
        String str = "bbbaa";
        rearrangeString(str);
    }
}


