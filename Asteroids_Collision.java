class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stk =new Stack<>();
        int n=asteroids.length;

        for(int i=0;i<n;i++) {
            //for(int val: asteroids){ }
            //if positive value push into stack
            if(asteroids[i] >  0){
                stk.push(asteroids[i]);
            }
            //if negative value compare and explode
            else{
                while(stk.size()>0 && stk.peek() >0 && stk.peek() < -asteroids[i]) {
                    stk.pop();
                }
                if(stk.size() >0 && stk.peek() == -asteroids[i]){
                    stk.pop();
                }
                else if(stk.size() > 0 && stk.peek() > -asteroids[i] ){
                    // [-2,2,-1,-2] dont use break;
                }else{
                    stk.push(asteroids[i]);
                }
            }
        }
        int[] ans=new int[stk.size()];
        int i = ans.length-1;
        while(i>=0){
            ans[i]=stk.pop();
            i--;
        }
        return ans;
    }
}