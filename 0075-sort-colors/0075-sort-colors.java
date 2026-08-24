class Solution {
    public void sortColors(int[] nums) {

        int[] count = new int[3];

        for (int i : nums) {
            count[i] = count[i] + 1;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {

            if (count[j] > 0) {
                nums[i] = j;
                count[j]--;
            } else {
                j++;
                i--;
            }
        }

    }
}