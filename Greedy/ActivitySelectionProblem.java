package Greedy;

import java.util.Arrays;
/*
* Java program for activity selection problem.
*/
import java.util.Comparator;

public class ActivitySelectionProblem {

    // The following implementation assumes that the activities
    // are already sorted according to their finish time

    public static void printMaxActivities(int s[], int f[], int n) {

        int i, j;

        System.out.println(
                "Following activities are selected");

        // The first activity always gets selected
        i = 0;
        System.out.print(i + "---> ");

        // Consider rest of the activities
        for (j = 1; j < n; j++) {
            // If this activity has start time greater than or equal to the finish time of
            // previously
            // selected activity, then select it
            if (s[j] >= f[i]) {
                System.out.print(j + " ");
                i = j;
            }
        }
    }

    // ----------- Without Finished Array sorted----------------------------->
    static class Activity {
        int startime, finishtime;

        Activity(int starttime, int finishtime) {
            this.startime = starttime;
            this.finishtime = finishtime;
        }

    }

    // class to define user defined comparator
    static class Compare {

        // A utility function that is used for sorting
        // activities according to finish time
        void compare(Activity arr[], int n) {
            Arrays.sort(arr, new Comparator<Activity>() {
                @Override
                public int compare(Activity s1, Activity s2) {
                    return s1.finishtime - s2.finishtime;
                }
            });
        }
    }

    public static void ActivitySelecMethod(Activity[] arr, int n) {
        // Sort jobs according to finish time
        Compare obj = new Compare();
        obj.compare(arr, n);
        System.out.println(
                "Following activities are selected :");

        // The first activity always gets selected
        int i = 0;
        System.out.print("(" + arr[i].startime + ", "
                + arr[i].finishtime + ")");

        // Consider rest of the activities
        int ans = 1;
        for (int j = 1; j < n; j++) {

            // If this activity has start time greater than
            // or equal to the finish time of previously
            // selected activity, then select it
            if (arr[j].startime >= arr[i].finishtime) {
                System.out.print(", (" + arr[j].startime + ", "
                        + arr[j].finishtime + ")");
                i = j;
                ans++;

            }
        }
        System.out.println();
        System.out.println("Ans : " + ans);
    }

    public static void main(String[] args) {
        // int s[] = { 1, 3, 0, 5, 8, 5 };
        // int f[] = { 2, 4, 6, 7, 9, 9 };
        // int n = s.length;

        // Function call
        // printMaxActivities(s, f, n);

        int n = 6;
        Activity arr[] = new Activity[n];
        arr[0] = new Activity(5, 9);
        arr[1] = new Activity(1, 2);
        arr[2] = new Activity(3, 4);
        arr[3] = new Activity(0, 6);
        arr[4] = new Activity(5, 7);
        arr[5] = new Activity(8, 9);

        Activity arr2[] = new Activity[] { new Activity(5, 24),
                new Activity(15, 25),
                new Activity(27, 40),
                new Activity(50, 60) };

        ActivitySelecMethod(arr2, 4);

    }
}
