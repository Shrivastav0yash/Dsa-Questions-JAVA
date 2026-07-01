class Solution {
    //Optimal Solution

    //Method for atmost
    public int subarrayAtMost(int[] nums, int k){
        
        if(k < 0) return 0;

        int n = nums.length;
        int count = 0;
        int sum = 0;
        int l = 0;
        int r = 0;
        while ( r < n){
            sum = sum + nums[r];

            while(sum > k){
                sum = sum - nums[l];
                l++;
            }

            count = count + (r -l + 1);
            r++;
        }
        return count;
    }

    //exact = atmost(k) - atmost(k-1);
    public int numSubarraysWithSum(int[] nums, int goal) {
        return subarrayAtMost(nums, goal) - subarrayAtMost(nums, goal-1);
    }
}