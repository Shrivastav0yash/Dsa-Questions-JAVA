class Solution {
    public int maximumGap(int[] nums) {
        
        if(nums == null || nums.length < 2) return 0;

        Arrays.sort(nums);

        int maxG = nums[1] - nums[0];

        for(int i=2; i<nums.length; i++){
            maxG = Math.max(maxG, (nums[i] - nums[i-1]));
        }

        return maxG;
    }
}