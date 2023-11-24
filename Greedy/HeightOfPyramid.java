package Greedy;

// Java program to find maximum height pyramid 
// from the given object width. 

import java.util.Arrays;

class HeightOfPyramid {

    // Returns maximum number of pyramidcal levels n boxes of given widths.
    static int maxLevel(int[] boxes, int n) {

        // Sort objects in increasing order of widths
        Arrays.sort(boxes);

        int ans = 1; // Initialize result

        int prev_width = boxes[0];
        int prev_count = 1;

        // Number of object in current level.
        int curr_count = 0;

        // Width of current level.
        int curr_width = 0;
        for (int i = 1; i < n; i++) {

            curr_width += boxes[i];
            curr_count += 1;

            if (curr_width > prev_width && curr_count > prev_count) {

                prev_width = curr_width;
                
                prev_count = curr_count;

                curr_count = 0;
                curr_width = 0;

                ans++;
            }
        }

        return ans;
    }

    static public void main(String[] args) {
        int[] boxes = { 10, 20, 30, 50, 60, 70 };
        int n = boxes.length;
        System.out.println(maxLevel(boxes, n));
    }
}
