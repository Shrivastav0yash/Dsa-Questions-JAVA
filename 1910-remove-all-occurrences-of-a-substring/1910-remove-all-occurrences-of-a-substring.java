class Solution {
    public String removeOccurrences(String s, String part) {
        //String

        String result = "";
        int n = s.length();
        int p = part.length();

        for(int i=0; i<n; i++){

            result = result + s.charAt(i);

            if(
                result.length() >= p 
                && 
                result.substring(result.length()-p, result.length()).equals(part)){
                    result = result.substring(0, result.length()-p);
            }
        }

        return result;
    }
}