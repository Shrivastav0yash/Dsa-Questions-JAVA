class Solution {
    
    public int func(int[] nums, int k){
        //Optimal 
        int count = 0;
        int n = nums.length;
        int l = 0;
        int r = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        if(k < 0) return 0;

        while( r < n){
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while(map.size() > k){
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }

            count += r-l+1;
            r++;
        }

        return count;
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k) -  func(nums,k-1);
    }
}