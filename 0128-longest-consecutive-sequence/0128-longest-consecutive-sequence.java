class Solution {
    public int longestConsecutive(int[] nums) {
        //HashSet
        HashSet<Integer> set = new HashSet<>();
        int longest = 1;
        int n = nums.length;
        if( n == 0) return 0;

        for(int i : nums) set.add(i);

        for(int i : set){ //2
            if(!set.contains(i-1)){
                int x = i;
                int count = 1;
                while(set.contains(x+1)){
                    x++;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        
        return longest;
    }
}