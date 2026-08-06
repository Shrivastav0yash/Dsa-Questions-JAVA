class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //Monolithic Stack
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for(int i=n-1; i>=0; i--){

            //Pop when element >= stack top
            while(!stack.empty() && temperatures[i] >= temperatures[stack.peek()]){
                stack.pop();
            }

            //calculate result
            if(stack.empty()) result[i] = 0;
            else result[i] = stack.peek() - i;

            //push
            stack.push(i);

        }

        return result;
    }
}