// Problem Link : https://leetcode.com/problems/contains-duplicate/description/

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: nums = [1, 2, 3, 1]

    Step-by-step execution:

    Initial:
    set = {}

    i = 0 → nums[0] = 1 → add → set = [1]
    i = 1 → nums[1] = 2 → add → set = [1, 2]
    i = 2 → nums[2] = 3 → add → set = [1, 2, 3]
    i = 3 → nums[3] = 1 → already exists → set remains [1, 2, 3]

    After loop:
    nums.length = 4
    set.size() = 3

    Since 4 > 3 → duplicate exists

    Final Output:
    true


    ----------------

    Input: nums = [1, 2, 3, 4]

    set = [1, 2, 3, 4]
    nums.length = 4
    set.size() = 4

    Since 4 == 4 → no duplicate

    Final Output:
    false
*/

import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        
        // Step 1: Create HashSet (stores only unique elements)
        HashSet<Integer> set = new HashSet<>();
        
        // Step 2: Add all elements into set
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }

        // Step 3: Compare sizes
        if(nums.length > set.size()) return true;

        // Step 4: No duplicates found
        return false;
    }
}

/*
    TIME COMPLEXITY:
    ----------------
    O(n) 
    - Traversing array once
    - HashSet insertion is O(1) on average

    SPACE COMPLEXITY:
    ----------------
    O(n)
    - In worst case, all elements are unique and stored in set
*/
