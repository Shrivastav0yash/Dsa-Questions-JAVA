class Solution {
    public int numberOfSubstrings(String s) {
        //Optimal Force
        int n = s.length();
        int count = 0;
        int a = -1, b  = -1, c = -1;

        for(int i=0; i<n ; i++){
            
            if(s.charAt(i) == 'a') a = i;
            if(s.charAt(i) == 'b') b = i;
            if(s.charAt(i) == 'c') c = i;

            if(a!= -1 && b!= -1 && c!= -1) count += Math.min(a , Math.min(b,c)) + 1;
        }

    return count;
    }
}