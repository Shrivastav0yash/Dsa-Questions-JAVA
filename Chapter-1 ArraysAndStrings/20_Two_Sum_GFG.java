// Problem Link : https://www.geeksforgeeks.org/problems/key-pair5616/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 4, 45, 6, 10, 8], target = 16

    Step-by-step execution:

    Initial:
    set = {}

    i = 1 → a = 16 - 1 = 15 → not in set
    add 1 → set = [1]

    i = 4 → a = 16 - 4 = 12 → not in set
    add 4 → set = [1, 4]

    i = 45 → a = 16 - 45 = -29 → not in set
    add 45 → set = [1, 4, 45]

    i = 6 → a = 16 - 6 = 10 → not in set
    add 6 → set = [1, 4, 45, 6]

    i = 10 → a = 16 - 10 = 6 → found in set

    Return true

    Final Output:
    true


    ----------------

    Input: arr = [1, 2, 4, 3, 6], target = 10

    i = 1 → need 9 → not found → set = [1]
    i = 2 → need 8 → not found → set = [1,2]
    i = 4 → need 6 → not found → set = [1,2,4]
    i = 3 → need 7 → not found → set = [1,2,4,3]
    i = 6 → need 4 → found → return true

    Final Output:
    true
*/

import java.util.HashSet;

class Solution {
    boolean twoSum(int arr[], int target) {
        
        // Step 1: Create HashSet to store elements
        HashSet<Integer> set = new HashSet<>();
        
        // Step 2: Traverse array
        for (int i : arr) {
            
            // Find required complement
            int a = target - i;
            
            // Step 3: Check if complement exists
            if (set.contains(a)) {
                return true;
            }
            
            // Step 4: Store current element
            set.add(i);
        }
        
        // Step 5: No pair found
        return false;
    }
}

/*
    TIME COMPLEXITY:
    ----------------
    O(n)
    - Single traversal of array
    - HashSet operations are O(1) on average

    SPACE COMPLEXITY:
    ----------------
    O(n)
    - In worst case, storing all elements in set
*/
