// Problem Link : https://www.geeksforgeeks.org/problems/search-an-element-in-an-array-1587115621/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [10, 20, 30, 40, 50], x = 30

    Step-by-step execution:

    Iteration 1: i = 0 → arr[0] = 10 → 10 != 30 ❌
    Iteration 2: i = 1 → arr[1] = 20 → 20 != 30 ❌
    Iteration 3: i = 2 → arr[2] = 30 → 30 == 30 ✅

    Element found at index 2
    Return 2

    Final Output:
    2


    ----------------

    Input: arr = [10, 20, 30, 40, 50], x = 60

    Iteration 1: i = 0 → 10 != 60 ❌
    Iteration 2: i = 1 → 20 != 60 ❌
    Iteration 3: i = 2 → 30 != 60 ❌
    Iteration 4: i = 3 → 40 != 60 ❌
    Iteration 5: i = 4 → 50 != 60 ❌

    Element not found
    Return -1

    Final Output:
    -1
*/

class Solution {
    public int search(int arr[], int x) {
        
        // Step 1: Traverse the array
        for (int i = 0; i < arr.length; i++) {
            
            // Step 2: Check if current element matches x
            if (arr[i] == x) {
                return i; // Element found, return index
            }
        }
        
        // Step 3: If element not found, return -1
        return -1;
    }
}