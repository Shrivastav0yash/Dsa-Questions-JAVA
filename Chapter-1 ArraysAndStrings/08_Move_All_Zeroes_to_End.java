// Problem Link : https://www.geeksforgeeks.org/problems/move-all-zeroes-to-end-of-array0751/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 0, 2, 0, 3, 0, 4]

    Step-by-step execution:

    Initial:
    n = 7
    j = -1

    Step 1: Find first zero
    i = 0 → arr[0] = 1 → skip
    i = 1 → arr[1] = 0 → j = 1 (first zero found)

    Step 2: Traverse from j+1 and swap non-zero elements

    i = 2 → arr[2] = 2 (non-zero)
    swap(arr[2], arr[1]) → [1, 2, 0, 0, 3, 0, 4]
    j = 2

    i = 3 → arr[3] = 0 → skip

    i = 4 → arr[4] = 3 (non-zero)
    swap(arr[4], arr[2]) → [1, 2, 3, 0, 0, 0, 4]
    j = 3

    i = 5 → arr[5] = 0 → skip

    i = 6 → arr[6] = 4 (non-zero)
    swap(arr[6], arr[3]) → [1, 2, 3, 4, 0, 0, 0]
    j = 4

    Final Output:
    [1, 2, 3, 4, 0, 0, 0]
*/

class Solution {
    void pushZerosToEnd(int[] arr) {
        
        // Step 1: Get array length
        int n = arr.length;
        
        // Step 2: Find index of first zero
        int j = -1;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        
        // If no zero found, array is already valid
        if (j == -1) return;
        
        // Step 3: Traverse and swap non-zero elements with zero
        for (int i = j + 1; i < n; i++) {
            
            if (arr[i] != 0) {
                
                // Swap arr[i] with arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                // Move j to next zero position
                j++;
            }
        }
    }
}
