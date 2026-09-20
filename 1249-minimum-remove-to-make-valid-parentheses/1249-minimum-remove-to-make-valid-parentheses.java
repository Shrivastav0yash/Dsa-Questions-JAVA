class Solution {
    public String minRemoveToMakeValid(String s) {
        //Approach III
        int open = 0;
        int n = s.length(); 
        String temp = "";

        for(int i=0; i<n; i++){
            if(s.charAt(i) == '('){
                open++;
                temp = temp + s.charAt(i);
            }
            else if( s.charAt(i) == ')'){
                if(open > 0){
                    open--;
                    temp=temp + s.charAt(i);
                }
            }
            else{
                temp = temp + s.charAt(i);
            }
        }


        String result = "";
        for(int i=temp.length()-1; i>=0; i--){
            
            if(temp.charAt(i) == '(' && open > 0)
                open--;
            else
                result = result + temp.charAt(i);

        }

        result = new StringBuilder(result).reverse().toString();
        return result;

    }
}