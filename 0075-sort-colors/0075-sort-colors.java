//Selection Sort
class Solution {
    public void sortColors(int[] nums) {
        int minInd;

        for(int i=0; i<nums.length; i++){
            minInd = i;
            for(int j = i+1; j<nums.length; j++){
                if(nums[j] < nums[minInd]){
                    minInd = j;
                }
            }

            int temp = nums[minInd];
            nums[minInd] = nums[i];
            nums[i] = temp;
        }
    }
}