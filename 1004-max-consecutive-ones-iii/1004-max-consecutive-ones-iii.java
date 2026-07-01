class Solution {
    public int longestOnes(int[] nums, int k) {
        //Optimal Sliding Windows
        int n = nums.length;
        int len = 0;
        int l = 0;
        int r = 0;
        int zeros = 0;

        while( r < n ){

            if(nums[r] == 0) zeros++;

            if(zeros <= k){
                len = Math.max(len, (r-l+1));
            }
            else{
                if(nums[l] == 0) zeros--;
                l++;
            }

            r++;
        }


        return len;
    }
}