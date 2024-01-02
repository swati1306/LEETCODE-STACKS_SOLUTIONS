
class MinStack {
    Stack<Integer> valueStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public MinStack() {
    }

    public void push(int val) {
        if(valueStack.size() == 0){
            valueStack.push(val);
            minStack.push(val);
            return;
        }
        valueStack.push(val);
        if(val <= minStack.peek()){
            minStack.push(val);
        }
    }

    public void pop() {
        if(valueStack.size() != 0){
            int temp = valueStack.pop();
            if(temp == minStack.peek()){
                minStack.pop();
            }

        }
    }

    public int top() {
        if(valueStack.size() == 0){
            return -1;
        }
        else{
            return valueStack.peek();
        }
    }

    public int getMin() {
        if(minStack.size() == 0){
            return -1;
        }
        else{
            return minStack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */