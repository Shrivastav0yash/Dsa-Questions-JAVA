// Problem Link : https://www.geeksforgeeks.org/problems/sort-an-array-of-0s-1s-and-2s4231/1

/*
    DRY RUN EXAMPLE:
    ----------------
    Input: arr = [2, 0, 2, 1, 1, 0]

    Step-by-step execution:

    Initial:
    zero = 0, one = 0, two = 0

    Counting phase:
    i = 0 → 2 → two = 1
    i = 1 → 0 → zero = 1
    i = 2 → 2 → two = 2
    i = 3 → 1 → one = 1
    i = 4 → 1 → one = 2
    i = 5 → 0 → zero = 2

    After counting:
    zero = 2, one = 2, two = 2

    Filling phase:

    Fill 0s:
    arr[0] = 0
    arr[1] = 0
    → [0, 0, ?, ?, ?, ?]

    Fill 1s:
    from index 2 to 3
    arr[2] = 1
    arr[3] = 1
    → [0, 0, 1, 1, ?, ?]

    Fill 2s:
    from index 4 to end
    arr[4] = 2
    arr[5] = 2

    Final Output:
    [0, 0, 1, 1, 2, 2]
*/

class Solution {
    public void sort012(int[] arr) {
        
        // Step 1: Count number of 0s, 1s, and 2s
        int zero = 0;
        int one = 0;
        int two = 0;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
            } 
            else if (arr[i] == 1) {
                one++;
            } 
            else {
                two++;
            }
        }
        
        // Step 2: Fill array with 0s
        for (int i = 0; i < zero; i++) {
            arr[i] = 0;
        }
        
        // Step 3: Fill array with 1s
        int x = zero + one;
        for (int i = zero; i < x; i++) {
            arr[i] = 1;
        }
        
        // Step 4: Fill array with 2s
        for (int i = x; i < arr.length; i++) {
            arr[i] = 2;
        }
    }
}

/*
    TIME COMPLEXITY:
    ----------------
    O(n)
    - One pass for counting
    - One pass for filling

    SPACE COMPLEXITY:
    ----------------
    O(1)
    - No extra space used
*/