package recursion;

// JAVA recursive function to 
// solve tower of hanoi puzzle 
// import java.io.*; 
// import java.math.*; 
// import java.util.*; 

class towerOfHanoi {
    static void towerOfHanoiMethod(int n, char src, char helper, char dest) {
        if (n == 1) {
            System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
            return;
        }
        towerOfHanoiMethod(n - 1, src, dest, helper);
        System.out.println("Move disk " + n + " from rod " + src + " to rod " + dest);
        towerOfHanoiMethod(n - 1, helper, src, dest);
    }

    // Driver code
    public static void main(String args[]) {
        int N = 1;

        // A, B and C are names of rods
        towerOfHanoiMethod(N, 'S', 'H', 'D');
    }
}
