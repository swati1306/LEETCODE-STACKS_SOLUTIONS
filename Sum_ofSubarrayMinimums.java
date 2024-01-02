// 907. Sum of Subarray Minimums
class Solution {
    public int sumSubarrayMins(int[] arr) {
        long mod = (long) 1000000007;
        long ans = 0;

        int[] nsl_ar = nslIndex(arr);
        int[] nsr_ar = nsrIndex(arr);

        for (int i = 0; i < arr.length; i++) {
            int s2 = nsl_ar[i] + 1, e2 = nsr_ar[i] - 1;
            long total_Min = (long) (i - s2 + 1) * (e2 - i + 1);
            ans = ans + (total_Min) * arr[i];
            ans %= mod;
        }

        return (int) (ans % mod);
    }

    public int[] nslIndex(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (stk.size() > 0 && A[stk.peek()] >= A[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                res[i] = stk.peek();
            } else {
                res[i] = -1;
            }
            stk.push(i);
        }
        return res;
    }

    public int[] nsrIndex(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 0 && A[stk.peek()] > A[i]) {
                stk.pop();
            }
            if (stk.size() > 0) {
                res[i] = stk.peek();
            } else {
                res[i] = n;
            }
            stk.push(i);
        }
        return res;
    }
}

