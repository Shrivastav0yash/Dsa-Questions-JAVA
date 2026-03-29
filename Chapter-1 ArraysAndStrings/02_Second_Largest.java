// Problem Link : https://www.geeksforgeeks.org/problems/second-largest3735/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [12, 3, 1, 10, 34, 35]

    Step-by-step execution:

    Initial:
    largest = 0
    secL = -1

    First Loop (Find Largest):

    Iteration 1: i = 12 → largest = max(0, 12) = 12
    Iteration 2: i = 3  → largest = max(12, 3) = 12
    Iteration 3: i = 1  → largest = max(12, 1) = 12
    Iteration 4: i = 10 → largest = max(12, 10) = 12
    Iteration 5: i = 34 → largest = max(12, 34) = 34
    Iteration 6: i = 35 → largest = max(34, 35) = 35

    Now:
    largest = 35

    Second Loop (Find Second Largest):

    Iteration 1: i = 12 → secL = max(-1, 12) = 12
    Iteration 2: i = 3  → secL = max(12, 3) = 12
    Iteration 3: i = 1  → secL = max(12, 1) = 12
    Iteration 4: i = 10 → secL = max(12, 10) = 12
    Iteration 5: i = 34 → secL = max(12, 34) = 34
    Iteration 6: i = 35 → skip (equal to largest)

    Final Output:
    secL = 34
*/

class Solution {
    public int getSecondLargest(int[] arr) {
        
        // Step 1: Initialize variables
        int largest = 0;
        int secL = -1;
        
        // Step 2: Find the largest element
        for(int i : arr){
            largest = Math.max(i, largest);
        }
        
        // Step 3: Find second largest element
        for(int i : arr){
            if(i != largest){
                secL = Math.max(secL, i);
            }
        }
        
        // Step 4: Return result
        return secL;
    }
}