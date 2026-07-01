class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int len = 0;

        while(r < n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+ 1);
            while(map.get(nums[r]) > k){
                map.put(nums[l], map.getOrDefault(nums[l], 0)- 1);
                l++;
            }
            len = Math.max(len, r-l+1);
            r++;
        }

        return len;

    }
}