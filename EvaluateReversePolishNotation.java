// 150. Evaluate Reverse Polish Notation : https://leetcode.com/problems/evaluate-reverse-polish-notation/?envType=list&envId=pdyr8y7r
class Solution {
    public int evalRPN(String[] tokens) {
        int n= tokens.length;
        Stack <Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            if(tokens[i].equals("+") || tokens[i].equals("-")  || tokens[i].equals("*") || tokens[i].equals("/") ){
                char op=tokens[i].charAt(0);
                int b=st.pop() , a=st.pop();
                if(op == '+'){
                    st.push(a+b);
                }
                else if(op == '-'){
                    st.push(a - b);
                }
                else if(op == '*'){
                    st.push(a * b);
                }
                else if(op == '/'){
                    st.push(a/b);
                }
            }
            else {
                st.push(Integer.parseInt(tokens[i]) );
            }
        }
        return st.pop();
    }
}