class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number = 0;
        int result = 0;
        int sign = 1;

        for(int i=0; i<s.length(); i++){

            //create a number
            if(Character.isDigit(s.charAt(i))){
                number = (number * 10) + (s.charAt(i) - '0');
            }
            //agar mujhe + mile
            else if(s.charAt(i) == '+'){
                result += (number * sign);
                number = 0;
                sign = 1;
            }
            else if(s.charAt(i) == '-'){
                result += (number * sign);
                number = 0;
                sign = -1;
            }
            else if(s.charAt(i) == '('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                number = 0;
                sign = 1;
            }
            else if(s.charAt(i) == ')'){
                result += (number * sign);
                number = 0;
                int stack_sign = stack.peek();
                stack.pop();
                int last_result = stack.peek();
                stack.pop();
                result *= stack_sign;
                result += last_result;
            }

        }

        result += (number * sign);

        return result;

    }
}