// Problem Link : https://www.geeksforgeeks.org/problems/max-consecutive-one/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 1, 0, 0, 0, 1, 1, 1]

    Step-by-step execution:

    First Pass: Find maximum consecutive 1s

    Initial:
    countOne = 0
    maxiOnes = 0

    i = 1 → countOne = 1 → maxiOnes = 1
    i = 1 → countOne = 2 → maxiOnes = 2
    i = 0 → countOne = 0
    i = 0 → countOne = 0
    i = 0 → countOne = 0
    i = 1 → countOne = 1 → maxiOnes = 2
    i = 1 → countOne = 2 → maxiOnes = 2
    i = 1 → countOne = 3 → maxiOnes = 3

    After first pass:
    maxiOnes = 3

    --------------------------------

    Second Pass: Find maximum consecutive 0s

    Initial:
    countZero = 0
    maxiZero = 0

    i = 1 → countZero = 0
    i = 1 → countZero = 0
    i = 0 → countZero = 1 → maxiZero = 1
    i = 0 → countZero = 2 → maxiZero = 2
    i = 0 → countZero = 3 → maxiZero = 3
    i = 1 → countZero = 0
    i = 1 → countZero = 0
    i = 1 → countZero = 0

    After second pass:
    maxiZero = 3

    Final Answer:
    max(maxiOnes, maxiZero) = max(3, 3) = 3

    Final Output:
    3
*/

class Solution {
    public int maxConsecBits(int[] arr) {
        
        // Step 1: Track maximum consecutive 1s
        int countOne = 0;
        int maxiOnes = 0;
        
        for (int i : arr) {
            if (i == 1) {
                countOne++;
                maxiOnes = Math.max(maxiOnes, countOne);
            } else {
                countOne = 0;
            }
        }
        
        // Step 2: Track maximum consecutive 0s
        int countZero = 0;
        int maxiZero = 0;
        
        for (int i : arr) {
            if (i == 0) {
                countZero++;
                maxiZero = Math.max(maxiZero, countZero);
            } else {
                countZero = 0;
            }
        }
        
        // Step 3: Return maximum of both
        return Math.max(maxiOnes, maxiZero);
    }
}