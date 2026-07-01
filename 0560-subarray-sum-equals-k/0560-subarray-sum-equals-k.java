class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mapp = new HashMap<>();
        mapp.put(0, 1);
        int presum = 0; 
        int count = 0;
        for(int i=0; i<nums.length;i++){
            presum = presum + nums[i];
            int remove = presum - k;
            count += mapp.getOrDefault(remove, 0);
            mapp.put(presum, mapp.getOrDefault(presum, 0) + 1);
        }

        return count;
    }
}