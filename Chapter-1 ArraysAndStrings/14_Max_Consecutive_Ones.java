// Problem Link : https://leetcode.com/problems/max-consecutive-ones/description/

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: nums = [1, 1, 0, 1, 1, 1]

    Step-by-step execution:

    Initial:
    maxi = 0
    count = 0

    Iteration 1: i = 1
    count = 1
    maxi = max(1, 0) = 1

    Iteration 2: i = 1
    count = 2
    maxi = max(2, 1) = 2

    Iteration 3: i = 0
    count = 0

    Iteration 4: i = 1
    count = 1
    maxi = max(1, 2) = 2

    Iteration 5: i = 1
    count = 2
    maxi = max(2, 2) = 2

    Iteration 6: i = 1
    count = 3
    maxi = max(3, 2) = 3

    Final Output:
    3
*/

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        // Step 1: Initialize variables
        int maxi = 0;   // stores maximum consecutive 1s
        int count = 0;  // stores current streak of 1s
        
        // Step 2: Traverse the array
        for (int i : nums) {
            
            // Step 3: If current element is 1, increase streak
            if (i == 1) {
                count++;
                maxi = Math.max(count, maxi);
            }
            
            // Step 4: If current element is 0, reset streak
            else {
                count = 0;
            }
        }
        
        // Step 5: Return maximum streak
        return maxi;
    }
}
