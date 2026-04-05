// Problem Link : https://www.geeksforgeeks.org/problems/find-unique-number/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [2, 3, 5, 4, 5, 3, 4]

    Step-by-step execution:

    Initial:
    xor = 0

    Iteration 1: i = 2
    xor = 0 ^ 2 = 2

    Iteration 2: i = 3
    xor = 2 ^ 3 = 1

    Iteration 3: i = 5
    xor = 1 ^ 5 = 4

    Iteration 4: i = 4
    xor = 4 ^ 4 = 0

    Iteration 5: i = 5
    xor = 0 ^ 5 = 5

    Iteration 6: i = 3
    xor = 5 ^ 3 = 6

    Iteration 7: i = 4
    xor = 6 ^ 4 = 2

    Final Output:
    2


    ----------------

    Why XOR works:
    --------------
    - Same numbers cancel out:
      a ^ a = 0
    - XOR with 0 keeps number same:
      a ^ 0 = a

    So all duplicate numbers become 0,
    and only unique number remains.
*/

class Solution {
    public int findUnique(int[] arr) {
        
        // Step 1: Initialize xor as 0
        int xor = 0;

        // Step 2: XOR all elements
        for (int i : arr) {
            xor ^= i;
        }

        // Step 3: Return unique element
        return xor;
    }
}

/*
    TIME COMPLEXITY:
    ----------------
    O(n)
    - Traverse the array once

    SPACE COMPLEXITY:
    ----------------
    O(1)
    - No extra space used
*/