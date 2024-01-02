//2390. Removing Stars From a String
class Solution {
    public String removeStars(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0; i < s.length() ;i++) {

            if(st.isEmpty()){
                st.push(s.charAt(i));
            }

            else if( s.charAt(i) =='*') {
                st.pop();
            }
            else{
                st.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(st.isEmpty() == false){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}