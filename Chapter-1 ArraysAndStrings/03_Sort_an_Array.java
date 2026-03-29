// Problem Link : https://leetcode.com/problems/sort-an-array/

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: nums = [5, 2, 3, 1]

    Step-by-step execution:

    Before Sorting:
    nums = [5, 2, 3, 1]

    Apply Arrays.sort(nums):

    After Sorting:
    nums = [1, 2, 3, 5]

    Final Output:
    [1, 2, 3, 5]
*/

import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        
        // Step 1: Use built-in sorting method
        Arrays.sort(nums);   // Sorts array in ascending order
        
        // Step 2: Return sorted array
        return nums;
    }
}