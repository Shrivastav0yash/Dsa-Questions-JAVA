class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int stream  = 1;
        int i = 0;

        while(i < target.length && stream <= n){

            stack.push(stream);
            result.add("Push");

            if(stack.peek() == target[i]){
                i++;
            }
            else{
                stack.pop();
                result.add("Pop");
            }
            stream++;
        }

        return result;
    }
}