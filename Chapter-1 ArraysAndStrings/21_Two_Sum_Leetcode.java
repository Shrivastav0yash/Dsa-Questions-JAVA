// Problem Link : https://leetcode.com/problems/two-sum/description/

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: nums = [2, 7, 11, 15], target = 9

    Step-by-step execution:

    Initial:
    map = {}

    i = 0 → nums[0] = 2
    rem = 9 - 2 = 7 → not found
    map = {2:0}

    i = 1 → nums[1] = 7
    rem = 9 - 7 = 2 → found in map at index 0

    Return [0, 1]

    Final Output:
    [0, 1]


    ----------------

    Input: nums = [3, 3], target = 6

    i = 0 → nums[0] = 3
    rem = 6 - 3 = 3 → not found
    map = {3:0}

    i = 1 → nums[1] = 3
    rem = 6 - 3 = 3 → found in map at index 0

    Return [0, 1]

    Final Output:
    [0, 1]
*/

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // Step 1: Create HashMap (value → index)
        HashMap<Integer, Integer> mapp = new HashMap<>();
        int n = nums.length;

        // Step 2: Traverse array
        for (int i = 0; i < n; i++) {
            
            // Find required complement
            int rem = target - nums[i];
            
            // Step 3: Check if complement exists
            if (mapp.containsKey(rem)) {
                return new int[]{mapp.get(rem), i};
            }
            
            // Step 4: Store current element with index
            mapp.put(nums[i], i);
        }

        // Step 5: If no solution found
        return new int[]{-1, -1};
    }
}

/*
    TIME COMPLEXITY:
    ----------------
    O(n)
    - Single traversal of array
    - HashMap operations are O(1) on average

    SPACE COMPLEXITY:
    ----------------
    O(n)
    - In worst case, storing all elements in map
*/