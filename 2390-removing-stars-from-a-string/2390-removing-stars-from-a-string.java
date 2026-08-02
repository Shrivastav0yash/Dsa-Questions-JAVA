class Solution {
    public String removeStars(String s) {
        //By Using Stack
        Stack<Character> st = new Stack<>();

        for( char ch : s.toCharArray()){

            if(ch != '*'){
                st.push(ch);
            }
            if(ch == '*'){
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();

        while( !st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}