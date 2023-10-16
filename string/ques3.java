package string;

// lexicographic order
public class ques3 {
    public static void main(String[] args) {
        String fruits[] = { "apple", "mango", "banana" };

        String largest = fruits[0];
        for (int i = 1; i < fruits.length; i++) {  //n  times
            if (largest.compareTo(fruits[i]) < 0) {   // x characters compare
                largest = fruits[i];
            }
        }
        System.out.println(" : " + largest);
    }
}

