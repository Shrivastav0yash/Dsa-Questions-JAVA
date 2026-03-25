// Problem Link : https://leetcode.com/problems/move-zeroes/
/*
    DRY RUN EXAMPLE:
    ----------------
    Input: nums = [0, 1, 0, 3, 12]

    Step-by-step execution:

    Initial:
    n = 5
    j = 0   // position to place next non-zero element

    i = 0 → nums[0] = 0 → skip

    i = 1 → nums[1] = 1 (non-zero)
    swap(nums[1], nums[0]) → [1, 0, 0, 3, 12]
    j = 1

    i = 2 → nums[2] = 0 → skip

    i = 3 → nums[3] = 3 (non-zero)
    swap(nums[3], nums[1]) → [1, 3, 0, 0, 12]
    j = 2

    i = 4 → nums[4] = 12 (non-zero)
    swap(nums[4], nums[2]) → [1, 3, 12, 0, 0]
    j = 3

    Final Output:
    [1, 3, 12, 0, 0]
*/

class Solution {
    public void moveZeroes(int[] nums) {
        
        // Step 1: Initialize pointer for placing non-zero elements
        int j = 0;
        
        // Step 2: Traverse the array
        for (int i = 0; i < nums.length; i++) {
            
            // Step 3: If current element is non-zero
            if (nums[i] != 0) {
                
                // Swap current element with position j
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                
                // Move j to next position
                j++;
            }
        }
    }
}