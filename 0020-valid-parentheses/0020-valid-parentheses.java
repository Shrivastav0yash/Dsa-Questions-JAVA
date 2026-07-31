class Solution {
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack<>();

        for(Character ch : s.toCharArray()){

            if(ch == '{'){
                stack.push('}');
            }
            else if(ch == '('){
                stack.push(')');
            }
            else if(ch == '['){
                stack.push(']');
            }
            else if(stack.empty() || stack.peek() != ch){
                return false;
            }
            else{
                stack.pop();
            }
        }

        if(stack.empty()) return true;

        return false;

    }
}