class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long result = 0;
        for(int i=0;i<n;i++){
            nums[i] = nums[i] - i;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);

        for(int j=1; j<n ; j++){
            int countOfJ = map.getOrDefault(nums[j],0);
            int totalNumsBeforeJ = j;
            int badPairs = totalNumsBeforeJ - countOfJ;
            result += badPairs;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }

        return result;
    }
}