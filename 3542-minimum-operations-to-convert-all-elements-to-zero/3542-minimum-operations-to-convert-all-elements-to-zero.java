class Solution {
    public int minOperations(int[] nums) {
        //Monotonic Stack
        Stack<Integer> st = new Stack<>();
        int result = 0;

        for(int i : nums){

            while(!st.empty() && i < st.peek()){
                st.pop();
            }
            if(i == 0) continue;

            if(st.empty() || i > st.peek()){
                st.push(i);
                result++;
            }
        }

        return result;
    }
}