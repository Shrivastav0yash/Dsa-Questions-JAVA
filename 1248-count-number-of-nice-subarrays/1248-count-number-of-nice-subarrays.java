class Solution {
    public int func(int[] nums, int goal){
        //Sliding Window
        int n = nums.length;
        int l = 0;
        int r = 0;
        int sumO = 0;
        int count = 0;

        while( r < n){
            sumO += nums[r] % 2;
            while(sumO > goal){
                sumO -= nums[l] % 2;
                l++;
            }
            count += r-l+1;
            r++;
        }

        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums, k) - func(nums, k-1);
    }
}