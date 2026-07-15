class Solution {
    public int gcd(int a,int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }

    public String gcdOfStrings(String str1, String str2) {
        
        String temp = str1 + str2;
        String temp2 = str2 + str1;

        if(!temp.equals(temp2)){
            return "";
        }

        int l1 = str1.length();
        int l2 = str2.length();

        int gcdLength = gcd(Math.max(l1,l2), Math.min(l1,l2));

        String output = "";

        for(int i=0; i<gcdLength; i++){
            output = output + str1.charAt(i);
        }

        return output;
    }
}