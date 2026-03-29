// Problem Link : https://www.geeksforgeeks.org/problems/intersection-of-two-sorted-arrays-with-duplicate-elements/1

/*

    DRY RUN EXAMPLE:
    ----------------
    Input:
    a = [1, 2, 2, 3, 4, 5]
    b = [2, 2, 3, 5, 6]

    Step-by-step execution:

    Initial:
    i = 0, j = 0
    inter = []

    Compare a[0] = 1 and b[0] = 2
    1 < 2 → move i
    i = 1

    Compare a[1] = 2 and b[0] = 2
    Equal → add 2
    inter = [2]
    i = 2, j = 1

    Check duplicate in a:
    a[2] == a[1] → duplicate → skip
    i = 3

    Check duplicate in b:
    b[1] == b[0] → duplicate → skip
    j = 2

    Compare a[3] = 3 and b[2] = 3
    Equal → add 3
    inter = [2, 3]
    i = 4, j = 3

    Compare a[4] = 4 and b[3] = 5
    4 < 5 → move i
    i = 5

    Compare a[5] = 5 and b[3] = 5
    Equal → add 5
    inter = [2, 3, 5]
    i = 6, j = 4

    Loop ends

    Final Output:
    [2, 3, 5]
*/

import java.util.ArrayList;

class Solution {

    // Function to find the intersection of two sorted arrays
    ArrayList<Integer> intersection(int[] a, int[] b) {
        
        // Step 1: Get lengths of both arrays
        int n = a.length;
        int m = b.length;
        
        // Step 2: Create result list
        ArrayList<Integer> inter = new ArrayList<>();
        
        // Step 3: Initialize two pointers
        int i = 0;
        int j = 0;
        
        // Step 4: Traverse both arrays
        while (i < n && j < m) {
            
            // Skip duplicate elements in first array
            if (i > 0 && a[i] == a[i - 1]) {
                i++;
                continue;
            }
            
            // Skip duplicate elements in second array
            if (j > 0 && b[j] == b[j - 1]) {
                j++;
                continue;
            }
            
            // If element in first array is smaller, move i
            if (a[i] < b[j]) {
                i++;
            }
            
            // If element in second array is smaller, move j
            else if (a[i] > b[j]) {
                j++;
            }
            
            // If both are equal, add to intersection
            else {
                inter.add(a[i]);
                i++;
                j++;
            }
        }
        
        // Step 5: Return result
        return inter;
    }
}