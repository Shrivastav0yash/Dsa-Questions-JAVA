class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int zeroIndex = -1;
        int n = nums.length;

        int[] result = new int[n];

        // Calculate product of non-zero elements
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zeroCount++;
                zeroIndex = i;
            } else {
                product *= nums[i];
            }
        }

        // Case 1: More than one zero
        if (zeroCount > 1) {
            return result; // All elements are already 0
        }

        // Case 2: Exactly one zero
        if (zeroCount == 1) {
            result[zeroIndex] = product;
            return result;
        }

        // Case 3: No zeros
        for (int i = 0; i < n; i++) {
            result[i] = product / nums[i];
        }

        return result;
    }
}