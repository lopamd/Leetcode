public class Solution {
    public boolean isValid(String s) {
        if(s == null)
            return true;
        Stack<Character> stack = new Stack<Character>();
        for(char c : s.toCharArray()){
            if(c == ')'){
                if(!stack.empty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }else if(c == '}'){
                if(!stack.empty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            }else if(c == ']'){
                if(!stack.empty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }else
                stack.push(c);
        }
        return stack.isEmpty();
    }
}