class Solution {
    public int minSwaps(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();

        for(int i=0; i<n ; i++){

            if(!stack.empty() && s.charAt(i) == ']' && stack.peek() == '[' ){
                stack.pop();
            }
            else{
                stack.push(s.charAt(i));
            }
        }
        int countOpen = 0;
        while(!stack.empty()){
            if(stack.peek() == ']'){
                countOpen++;
            }
            stack.pop();
        }

        return (countOpen + 1)/2;
    }
}