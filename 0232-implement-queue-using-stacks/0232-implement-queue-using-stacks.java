class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    int peekEl = -1;

    public MyQueue() {
        
    }
    
    public void push(int x) {
        
        if(input.empty()){
            peekEl = x;
        }

        input.push(x); //O(1)
    }
    
    public int pop() {

        if(output.empty()){ // Sometimes O(N) or O(1) = Amz O(1)
            while(!input.empty()){
                output.push(input.peek());
                input.pop();
            }
        }
        
        int val = output.peek();
        output.pop();
        return val;
    }
    
    public int peek() {//O(1)
        
        if(output.empty()) return peekEl;

        return output.peek();
    }
    
    public boolean empty() {//O(1)
        
        return (input.empty() && output.empty()) ? true : false;

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */