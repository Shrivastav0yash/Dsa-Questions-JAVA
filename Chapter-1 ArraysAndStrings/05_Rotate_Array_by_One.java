// Problem Link : https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 2, 3, 4, 5]

    Step-by-step execution:

    Initial:
    n = 5
    temp = arr[4] = 5

    Loop starts from i = 4 to 1:

    Iteration 1: i = 4 → arr[4] = arr[3] → [1, 2, 3, 4, 4]
    Iteration 2: i = 3 → arr[3] = arr[2] → [1, 2, 3, 3, 4]
    Iteration 3: i = 2 → arr[2] = arr[1] → [1, 2, 2, 3, 4]
    Iteration 4: i = 1 → arr[1] = arr[0] → [1, 1, 2, 3, 4]

    After loop:
    arr = [1, 1, 2, 3, 4]

    Place last element at first:
    arr[0] = temp = 5

    Final Output:
    [5, 1, 2, 3, 4]
*/

class Solution {
    public void rotate(int[] arr) {
        
        // Step 1: Get array length
        int n = arr.length;
        
        // Step 2: Store last element
        int temp = arr[n - 1];
        
        // Step 3: Shift elements to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        
        // Step 4: Place last element at first position
        arr[0] = temp;
    }
}