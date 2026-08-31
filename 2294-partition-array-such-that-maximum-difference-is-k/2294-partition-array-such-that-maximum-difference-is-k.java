class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int minVal = nums[0];
        
        for(int i =0; i < nums.length; i++){

            int diff = nums[i] - minVal;
            if(diff > k){
                count++;
                minVal = nums[i];
            }

        }

        return count;
    }
}