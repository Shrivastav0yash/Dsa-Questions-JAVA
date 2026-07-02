class Solution {
    public boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') {
                continue;
            }

            if (ch != ')') {
                stack.push(ch);
            } else {

                int trueCount = 0;
                int falseCount = 0;

                // Collect values inside brackets
                while (stack.peek() != '(') {

                    char curr = stack.pop();

                    if (curr == 't')
                        trueCount++;
                    else if (curr == 'f')
                        falseCount++;
                }

                // Remove '('
                stack.pop();

                // Operator
                char op = stack.pop();

                if (op == '!') {

                    stack.push(falseCount == 1 ? 't' : 'f');

                } else if (op == '&') {

                    stack.push(falseCount > 0 ? 'f' : 't');

                } else if (op == '|') {

                    stack.push(trueCount > 0 ? 't' : 'f');
                }
            }
        }

        return stack.peek() == 't';
    }
}