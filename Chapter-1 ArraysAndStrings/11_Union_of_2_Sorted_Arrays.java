// Problem Link : https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input:
    a = [1, 2, 2, 3, 4]
    b = [2, 3, 5]

    Step-by-step execution:

    Initial:
    i = 0, j = 0
    union = []

    Compare a[0] = 1 and b[0] = 2
    1 <= 2 → add 1
    union = [1]
    i = 1

    Compare a[1] = 2 and b[0] = 2
    2 <= 2 → add 2
    union = [1, 2]
    i = 2

    Compare a[2] = 2 and b[0] = 2
    2 already exists at last position → skip
    i = 3

    Compare a[3] = 3 and b[0] = 2
    3 > 2 → 2 already exists → skip
    j = 1

    Compare a[3] = 3 and b[1] = 3
    3 <= 3 → add 3
    union = [1, 2, 3]
    i = 4

    Compare a[4] = 4 and b[1] = 3
    4 > 3 → 3 already exists → skip
    j = 2

    Compare a[4] = 4 and b[2] = 5
    4 <= 5 → add 4
    union = [1, 2, 3, 4]
    i = 5

    First array finished

    Remaining elements in b:
    b[2] = 5 → add 5
    union = [1, 2, 3, 4, 5]

    Final Output:
    [1, 2, 3, 4, 5]
*/

import java.util.ArrayList;

class Solution {
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        
        // Step 1: Get lengths of both arrays
        int n1 = a.length;
        int n2 = b.length;
        
        // Step 2: Initialize two pointers
        int i = 0;
        int j = 0;
        
        // Step 3: Create result list
        ArrayList<Integer> union = new ArrayList<>();
        
        // Step 4: Traverse both arrays
        while (i < n1 && j < n2) {
            
            // If element in first array is smaller or equal
            if (a[i] <= b[j]) {
                
                // Add only if it is not duplicate
                if (union.size() == 0 || union.get(union.size() - 1) != a[i]) {
                    union.add(a[i]);
                }
                i++;
            } 
            else {
                
                // Add only if it is not duplicate
                if (union.size() == 0 || union.get(union.size() - 1) != b[j]) {
                    union.add(b[j]);
                }
                j++;
            }
        }
        
        // Step 5: Add remaining elements of first array
        while (i < n1) {
            if (union.size() == 0 || union.get(union.size() - 1) != a[i]) {
                union.add(a[i]);
            }
            i++;
        }
        
        // Step 6: Add remaining elements of second array
        while (j < n2) {
            if (union.size() == 0 || union.get(union.size() - 1) != b[j]) {
                union.add(b[j]);
            }
            j++;
        }
        
        // Step 7: Return union list
        return union;
    }
}