// Problem Link : https://www.geeksforgeeks.org/problems/check-if-an-array-is-sorted0701/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 2, 3, 4, 5]

    Step-by-step execution:

    Iteration 1: i = 0 → arr[0] = 1, arr[1] = 2 → 1 <= 2 ✅
    Iteration 2: i = 1 → arr[1] = 2, arr[2] = 3 → 2 <= 3 ✅
    Iteration 3: i = 2 → arr[2] = 3, arr[3] = 4 → 3 <= 4 ✅
    Iteration 4: i = 3 → arr[3] = 4, arr[4] = 5 → 4 <= 5 ✅

    No violation found → Array is sorted

    Final Output:
    true


    ----------------

    Input: arr = [1, 3, 2, 4]

    Iteration 1: i = 0 → 1 <= 3 ✅
    Iteration 2: i = 1 → 3 > 2 ❌ (Violation found)

    Return false immediately

    Final Output:
    false
*/

class Solution {
    public boolean isSorted(int[] arr) {
        
        // Step 1: Traverse the array
        for (int i = 0; i < arr.length - 1; i++) {
            
            // Step 2: Check if current element is greater than next
            if (arr[i] > arr[i + 1]) {
                return false; // Not sorted
            }
        }
        
        // Step 3: If no violation found, array is sorted
        return true;
    }
}