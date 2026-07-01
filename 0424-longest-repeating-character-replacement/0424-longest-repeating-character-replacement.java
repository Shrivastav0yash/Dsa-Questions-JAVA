class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int maxf = 0;
        
        HashMap<Character, Integer> map = new HashMap<>();

        while ( r < n ){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(r)));
            int changes = (r - l + 1) - maxf ;
            if(changes <= k){
                maxlen = Math.max(maxlen, (r -l + 1));
            }
            else{
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0) - 1);
                l++;
            }
            r++;
        }
        return maxlen;
    }
}