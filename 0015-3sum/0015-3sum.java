class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;
            if (i > 0 && nums[i] == nums[i - 1]) continue; //skip duplicate for i element
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    result.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++; //skip j duplicates
                    while (j < k && nums[k] == nums[k + 1]) k--; //skip k duplicates
                }
            }
        }
        
        return result;
    }
}