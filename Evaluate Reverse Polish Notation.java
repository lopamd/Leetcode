public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0 || tokens == null)
            return -1;
        String operators = "+-*/";
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            if(!operators.contains(tokens[i]))
                stack.push(tokens[i]);
            else{
                int a = Integer.valueOf(stack.pop());
                int b = Integer.valueOf(stack.pop());
                switch(tokens[i]){
                    case "+":
                        stack.push(String.valueOf(a + b));
                        break;
                    case "-":
                        stack.push(String.valueOf(b - a));
                        break;
                    case "*":
                        stack.push(String.valueOf(a * b));
                        break;
                    case "/":
                        stack.push(String.valueOf(b/a));
                        break;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }
}