// Problem Link : https://www.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 2, 3, 4, 5, 6, 7], d = 2

    Step-by-step execution:

    Initial:
    n = 7
    k = d % n = 2

    Step 1: Copy first k elements into temp
    temp = [1, 2]

    Step 2: Shift remaining elements to left
    i = 2 → arr[0] = arr[2] → [3, 2, 3, 4, 5, 6, 7]
    i = 3 → arr[1] = arr[3] → [3, 4, 3, 4, 5, 6, 7]
    i = 4 → arr[2] = arr[4] → [3, 4, 5, 4, 5, 6, 7]
    i = 5 → arr[3] = arr[5] → [3, 4, 5, 6, 5, 6, 7]
    i = 6 → arr[4] = arr[6] → [3, 4, 5, 6, 7, 6, 7]

    Now:
    arr = [3, 4, 5, 6, 7, 6, 7]

    Step 3: Copy temp elements to the end
    i = 5 → arr[5] = temp[0] = 1 → [3, 4, 5, 6, 7, 1, 7]
    i = 6 → arr[6] = temp[1] = 2 → [3, 4, 5, 6, 7, 1, 2]

    Final Output:
    [3, 4, 5, 6, 7, 1, 2]
*/

class Solution {
    static void rotateArr(int arr[], int d) {
        
        // Step 1: Get array length
        int n = arr.length;
        
        // Step 2: Handle cases where d > n
        int k = d % n;  // Effective rotations
        
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