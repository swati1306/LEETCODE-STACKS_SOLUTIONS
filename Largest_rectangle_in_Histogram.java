// 84. Largest Rectangle in Histogram : https://leetcode.com/problems/largest-rectangle-in-histogram/description/?envType=list&envId=pdyr8y7r
class Solution {
    public int largestRectangleArea(int[] heights) {

        int n=heights.length;
        int[] nearestLeft= smallerLeftIndex(heights);

        int[] nearestRight= smallerRightIndex(heights);
        int max=0;
        for(int i=0;i<n;i++){
            int h=heights[i];
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
