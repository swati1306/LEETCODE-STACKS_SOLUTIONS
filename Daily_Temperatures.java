//Links : 739. Daily Temperatures: https://leetcode.com/problems/daily-temperatures/description/
import java.util.*;

public class Daily_Temperatures {
    public int[] dailyTemperatures(int[] temperatures) {

        int N = temperatures.length;
        int[] ans = ngLeftIndex(temperatures, N);
        for (int i = 0; i < N; i++) {
            ans[i] = ans[i] - i;
        }
        return ans;
    }

    //nearer greater left index code
    public int[] ngLeftIndex(int[] ar, int N) {
        int[] ngl = new int[N];
        Stack<Integer> st = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            while (st.size() > 0 && ar[st.peek()] <= ar[i]) {
                st.pop();
            }
            if (st.size() > 0) {
                ngl[i] = st.peek();
            } else {
                ngl[i] = i;
            }
            st.push(i);
        }
        return ngl;
    }
}