class Solution {
    public String reverseWords(String s) {
        String[] temp = s.trim().split("\\s+"); // this line is important
        String output = "";
        for(int i=temp.length-1 ; i>=0; i--){
            output = output + temp[i] + " ";
        }
        return output.substring(0, output.length() -1);
    }
}