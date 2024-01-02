
//1047. Remove All Adjacent Duplicates In String
class Solution {
    public String removeDuplicates(String s) {

        Stack<Character> stk=new Stack<>();
        for(int i=0; i<s.length(); i++) {
            if(stk.isEmpty()) {
                stk.push(s.charAt(i));
            }
            else if(stk.peek().equals(s.charAt(i))){
                stk.pop();
            }
            else{
                stk.push(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while(stk.isEmpty() == false){
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}