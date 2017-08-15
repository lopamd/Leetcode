public class MyStack {
    Queue<Integer> input;
    Queue<Integer> output;
    /** Initialize your data structure here. */
    public MyStack() {
      input = new LinkedList<>();
      output = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        /*input.add(x);
        for(int i = 1; i < input.size(); i++)
            input.add(input.poll());*/
        if(input.isEmpty()){
            input.add(x);
            for(int i = 0; i < output.size(); i++)
                input.add(output.poll());
        }else{
            output.add(x);
            for(int i = 0; i < input.size(); i++)
                output.add(input.poll());
        }
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        //return input.poll();
        if(!input.isEmpty())
            return input.poll();
        else
            return output.poll();
    }
    
    /** Get the top element. */
    public int top() {
        //return input.peek();
        if(!input.isEmpty())
            return input.peek();
        else
            return output.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        //return input.isEmpty();
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */