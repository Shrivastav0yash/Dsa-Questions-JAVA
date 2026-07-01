class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int n = nums.length;

        for(int i=0;i<n;i++){
            int rem = target - nums[i];
            if(mapp.containsKey(rem)){
                return new int[]{mapp.get(rem), i};
            }
            mapp.put(nums[i],i);
        }

        return new int[]{-1, -1};
    }
}