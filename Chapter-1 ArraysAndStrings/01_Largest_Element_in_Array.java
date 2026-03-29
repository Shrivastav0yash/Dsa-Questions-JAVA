// Problem Link : https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [3, 8, 2, 10, 5]

    Step-by-step execution:

    Initial:
    result = 3

    Iteration 1 (i = 0):
    Compare arr[0] < arr[1] → 3 < 8 → true
    result = max(3, 8) = 8

    Iteration 2 (i = 1):
    Compare arr[1] < arr[2] → 8 < 2 → false
    result remains 8

    Iteration 3 (i = 2):
    Compare arr[2] < arr[3] → 2 < 10 → true
    result = max(8, 10) = 10

    Iteration 4 (i = 3):
    Compare arr[3] < arr[4] → 10 < 5 → false
    result remains 10

    Final Output:
    result = 10
*/

class Solution {
    public static int largest(int[] arr) {

        // Step 1: Get size of array
        int n = arr.length;

        // Step 2: Assume first element is the largest
        int result = arr[0];
        
        // Step 3: Traverse array till second last element
        for(int i=0; i<n-1; i++){
            
            // Step 4: Compare current element with next element
            // If next element is greater, update result
            if(arr[i] < arr[i+1]){
                result = Math.max(result, arr[i+1]);
            }
        }
        
        // Step 5: Return the largest element found
        return result;
    }
}