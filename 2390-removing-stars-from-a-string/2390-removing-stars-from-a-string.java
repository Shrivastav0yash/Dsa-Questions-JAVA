class Solution {
    public String removeStars(String s) {
        //By Using String
        String result = "";

        for(char c : s.toCharArray()){

            if(c == '*'){
                result = result.substring(0, result.length() -1);
            }
            else{
                result = result + c;
            }
        }

        return result;
    }
}