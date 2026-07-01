class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        int l = 0;
        int r = 0;
        int count = 0;
        int minlen = Integer.MAX_VALUE;
        int sindex = -1;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < m ; i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i),0) + 1);
        }

        while(r < n ){

            if(map.getOrDefault(s.charAt(r),0) > 0){
                count ++;
            }
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)-1);

            while( count == m){
                if((r-l+1) < minlen){
                    minlen = (r-l+1);
                    sindex = l;
                }
                map.put(s.charAt(l), map.getOrDefault(s.charAt(l),0) + 1);
                if(map.get(s.charAt(l)) > 0)
                    count--;
                l++;
            }
            r++;
        }

        if(sindex == -1) return "";

        return s.substring(sindex, sindex + minlen);
    }
}