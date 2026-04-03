// Problem Link : https://www.geeksforgeeks.org/problems/missing-number-in-array1416/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [1, 2, 4, 5]

    Step-by-step execution:

    Initial:
    arr.length = 4
    n = arr.length + 1 = 5

    Step 1: Find expected sum of numbers from 1 to n
    sum = n * (n + 1) / 2
        = 5 * 6 / 2
        = 15

    Step 2: Find actual sum of array elements
    sumArr = 0

    Add elements one by one:
    sumArr = 0 + 1 = 1
    sumArr = 1 + 2 = 3
    sumArr = 3 + 4 = 7
    sumArr = 7 + 5 = 12

    Step 3: Missing number
    missing = sum - sumArr
            = 15 - 12
            = 3

    Final Output:
    3
*/

class Solution {
    int missingNum(int arr[]) {
        
        // Step 1: Total count of numbers should be array length + 1
        long n = arr.length + 1;
        
        // Step 2: Calculate expected sum from 1 to n
        long sum = n * (n + 1) / 2;
        
        // Step 3: Calculate actual sum of array elements
        long sumArr = 0;
        for (int i : arr) {
            sumArr += i;
        }
        
        // Step 4: Missing number = expected sum - actual sum
        return (int) (sum - sumArr);
    }
}