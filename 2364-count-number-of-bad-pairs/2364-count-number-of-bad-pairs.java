class Solution {
    public long countBadPairs(int[] nums) {
        //pair form array
        //hashmap
        //counting
        //return

        for(int i = 0 ; i<nums.length; i++){
            nums[i] = nums[i] - i;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        long count = 0;
        map.put(nums[0], 1);

        for(int j =1 ; j<nums.length; j++){
            int countOfJ = map.getOrDefault(nums[j], 0);
            int countNumsbeforej = j;
            int badPairs = countNumsbeforej - countOfJ;
            count += badPairs;
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
        }


        return count;

    }
}