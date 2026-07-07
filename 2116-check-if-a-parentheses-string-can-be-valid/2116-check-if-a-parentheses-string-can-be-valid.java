class Solution {
    public boolean canBeValid(String s, String locked) {
        
        if(s.length() % 2 != 0) return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();

        for(int i=0; i<s.length(); i++){
            
            if(locked.charAt(i) == '0'){
                openClose.push(i);
            }
            else if(s.charAt(i) == '('){
                open.push(i);
            }
            else if(s.charAt(i) == ')'){
                if(!open.empty()){
                    open.pop();
                }
                else if(!openClose.empty()){
                    openClose.pop();
                }
                else{
                    return false;
                }
            }   
        }

        while(!open.empty() && !openClose.empty() && open.peek() < openClose.peek()){
            open.pop();
            openClose.pop();
        }

        return open.empty();
    }
}