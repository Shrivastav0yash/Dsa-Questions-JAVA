// Problem Link : https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1
/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 2, 3, 1, 1, 1, 1], k = 3

    Step-by-step execution:

    Initial:
    prefix_sum = 0
    len = 0
    map = {}

    i = 0 → arr[0] = 1
    prefix_sum = 1
    rem = 1 - 3 = -2 → not found
    map = {1:0}

    i = 1 → arr[1] = 2
    prefix_sum = 3
    prefix_sum == k → len = max(0, 2) = 2
    rem = 3 - 3 = 0 → not found
    map = {1:0, 3:1}

    i = 2 → arr[2] = 3
    prefix_sum = 6
    rem = 6 - 3 = 3 → found at index 1
    length = 2 - 1 = 1 → len = max(2,1) = 2
    map = {1:0, 3:1, 6:2}

    i = 3 → arr[3] = 1
    prefix_sum = 7
    rem = 7 - 3 = 4 → not found
    map = {1:0, 3:1, 6:2, 7:3}

    i = 4 → arr[4] = 1
    prefix_sum = 8
    rem = 8 - 3 = 5 → not found
    map = {1:0, 3:1, 6:2, 7:3, 8:4}

    i = 5 → arr[5] = 1
    prefix_sum = 9
    rem = 9 - 3 = 6 → found at index 2
    length = 5 - 2 = 3 → len = max(2,3) = 3
    map = {1:0, 3:1, 6:2, 7:3, 8:4, 9:5}

    i = 6 → arr[6] = 1
    prefix_sum = 10
    rem = 10 - 3 = 7 → found at index 3
    length = 6 - 3 = 3 → len = max(3,3) = 3

    Final Output:
    3
*/

import java.util.HashMap;

class Solution {
    public int longestSubarray(int[] arr, int k) {
        
        // Step 1: Create HashMap to store prefix_sum and index
        HashMap<Long, Integer> mapp = new HashMap<>();
        
        // Step 2: Initialize variables
        long prefix_sum = 0;
        int len = 0;
        
        // Step 3: Traverse array
        for (int i = 0; i < arr.length; i++) {
            
            // Add current element to prefix sum
            prefix_sum += arr[i];
            
            // Case 1: If prefix_sum equals k
            if (prefix_sum == k) {
                len = Math.max(len, i + 1);
            }
            
            // Case 2: Check if (prefix_sum - k) exists
            long rem = prefix_sum - k;
            if (mapp.containsKey(rem)) {
                int l = i - mapp.get(rem);
                len = Math.max(len, l);
            }
            
            // Store prefix_sum if not already present
            if (!mapp.containsKey(prefix_sum)) {
                mapp.put(prefix_sum, i);
            }
        }
        
        // Step 4: Return maximum length
        return len;
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
    - In worst case, storing all prefix sums in map
*/