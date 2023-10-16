import java.util.Stack;
import java.util.Arrays;

public class EthCode {
    static void calculateSpan(int price[], int n, int S[]) {

        Stack<Integer> st = new Stack<>();
        st.push(0);

        S[0] = 1;

        for (int i = 1; i < n; i++) {
//                      t                       f           
            while (!st.empty() && price[st.peek()] <= price[i])  //   f 
                st.pop();
            S[i] = (st.empty()) ? (i + 1) : (i - st.peek()); //  1 - 0   

            st.push(i);
        }
    }

    static void printArray(int arr[]) {
        System.out.print(Arrays.toString(arr));
    }

    public static void main(String[] args) {
    int price[] = { 10, 4, 5, 90, 120, 80 };
    int n = price.length;

    int S[] = new int[n];

    calculateSpan(price, n, S);

    printArray(S);
    }
}
