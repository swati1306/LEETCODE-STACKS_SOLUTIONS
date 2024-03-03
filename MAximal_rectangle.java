class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Calculate heights for each row
                if (matrix[i][j] == '1') {
                    heights[j] = heights[j] + 1;
                } else {
                    heights[j] = 0;
                }
            }

            // Calculate the largest rectangle area using the histogram algorithm
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] A) {
        int n=A.length;
        int[] nearestLeft= smallerLeftIndex(A);

        int[] nearestRight= smallerRightIndex(A);
        int max=0;
        for(int i=0;i<n;i++){
            int h=A[i];
            int s=nearestLeft[i], e=nearestRight[i];
            int W=e-s-1;
            int area=h*W;
            max=Math.max(max,area);
        }
        return max;
    }

    public int[] smallerLeftIndex(int[] A) {
        int n=A.length;
        int[] res= new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=0;i<n;i++) {
            while(stk.size() > 0 && A[stk.peek()] >= A[i]){
                stk.pop();
            }
            if(stk.size() >0){
                res[i]=stk.peek();
            }
            else{
                res[i]=-1;
            }
            stk.push(i);
        }
        return res;
    }
    public int[] smallerRightIndex(int[] A) {
        int n=A.length;
        int[] res= new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i=n-1 ;i>=0; i--) {
            while(stk.size() > 0 && A[stk.peek()] >= A[i]){
                stk.pop();
            }
            if(stk.size() >0){
                res[i]=stk.peek();
            }
            else{
                res[i]=n;
            }
            stk.push(i);
        }
        return res;
    }
}