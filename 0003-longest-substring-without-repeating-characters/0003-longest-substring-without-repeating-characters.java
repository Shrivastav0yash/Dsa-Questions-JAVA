class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Sliding Window - Optimal
        int len;
        int maxlen = 0;
        int l = 0;
        int r = 0;
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        
        while (r < n){

            if (hash[s.charAt(r)] != -1){ //duplicates remove and move l
                l = Math.max(l, hash[s.charAt(r)] + 1);
            }
            len = r - l + 1; //cal len
            maxlen = Math.max(len, maxlen); // cal max len
            hash[s.charAt(r)] = r; //mapp value add along with index
            r++;
        }

        return maxlen;
    }
}