// Problem Link : https://leetcode.com/problems/rotate-array/description/

/*

    DRY RUN EXAMPLE:
    ----------------
    (This code performs RIGHT ROTATION using LEFT ROTATION logic)

    Input: arr = [1, 2, 3, 4, 5, 6, 7], d = 2

    Step-by-step execution:

    Initial:
    n = 7
    k = d % n = 2
    k = n - k = 7 - 2 = 5   // Convert right rotation into left rotation

    So effectively:
    Left rotate by 5

    Step 1: Copy first k elements into temp
    temp = [1, 2, 3, 4, 5]

    Step 2: Shift remaining elements to left
    i = 5 → arr[0] = arr[5] → [6, 2, 3, 4, 5, 6, 7]
    i = 6 → arr[1] = arr[6] → [6, 7, 3, 4, 5, 6, 7]

    Now:
    arr = [6, 7, 3, 4, 5, 6, 7]

    Step 3: Copy temp elements to the end
    i = 2 → arr[2] = temp[0] = 1 → [6, 7, 1, 4, 5, 6, 7]
    i = 3 → arr[3] = temp[1] = 2 → [6, 7, 1, 2, 5, 6, 7]
    i = 4 → arr[4] = temp[2] = 3 → [6, 7, 1, 2, 3, 6, 7]
    i = 5 → arr[5] = temp[3] = 4 → [6, 7, 1, 2, 3, 4, 7]
    i = 6 → arr[6] = temp[4] = 5 → [6, 7, 1, 2, 3, 4, 5]

    Final Output:
    [6, 7, 1, 2, 3, 4, 5]
*/

class Solution {
    public void rotate(int[] arr, int d) {
        
        // Step 1: Get array length
        int n = arr.length;
        
        // Step 2: Convert right rotation to left rotation
        int k = d % n;   // Effective rotations
        k = n - k;       // Convert to left rotation
        
        // Step 3: Store first k elements in temp array
        int[] temp = new int[k];
        for (int i = 0; i < k; i++) {
            temp[i] = arr[i];
        }
        
        // Step 4: Shift remaining elements to the left
        for (int i = k; i < n; i++) {
            arr[i - k] = arr[i];
        }
        
        // Step 5: Copy temp elements to the end
        for (int i = n - k; i < n; i++) {
            arr[i] = temp[i - (n - k)];
        }
    }
}