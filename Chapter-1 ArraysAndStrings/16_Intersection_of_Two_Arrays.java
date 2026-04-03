// Problem Link : https://leetcode.com/problems/intersection-of-two-arrays/description/

/*
==========================================================
INTERSECTION OF TWO ARRAYS
==========================================================

Problem:
Return an array of unique common elements present in both arrays.

Example:
Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]

----------------------------------------------------------
APPROACH 1: USING TWO HASHSETS
----------------------------------------------------------

Idea:
1. Store all elements of nums1 in set1
2. Traverse nums2
3. If element exists in set1, add it to set2
4. Convert set2 to array

Why it works?
- set1 helps in fast lookup
- set2 ensures uniqueness in result

Time Complexity:
- O(n + m)
  n = size of nums1
  m = size of nums2

Space Complexity:
- O(n + k)
  n for set1
  k for set2 (result)

----------------------------------------------------------
DRY RUN (Approach 1)
----------------------------------------------------------

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Step 1: Store nums1 in set1
set1 = [1,2]

Step 2: Traverse nums2
j = 2 → found in set1 → add to set2
set2 = [2]

j = 2 → already in set2 → no duplicate added

Final Output:
[2]
*/
/* 
import java.util.*;

class Solution {
    public int[] intersection(int[] num1, int[] num2) {
        
        // Step 1: Store elements of first array in set1
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        for (int i : num1) {
            set1.add(i);
        }

        // Step 2: Find common unique elements
        for (int j : num2) {
            if (set1.contains(j)) {
                set2.add(j);
            }
        }

        // Step 3: Convert result set into array
        int[] result = new int[set2.size()];
        int x = 0;
        for (int i : set2) {
            result[x] = i;
            x++;
        }

        return result;
    }
}
    */

/*
----------------------------------------------------------
APPROACH 2: HASHSET + REMOVE DUPLICATES (BEST)
----------------------------------------------------------

Idea:
1. Store all elements of nums1 in set1
2. Traverse nums2
3. If element exists in set1:
   - add to result
   - remove from set1
4. Convert result list to array

Why it works?
- HashSet gives O(1) average lookup
- Removing element avoids duplicate answers
- No need for second result set

Time Complexity:
- O(n + m)

Space Complexity:
- O(n + k)
  n for set1
  k for result list

----------------------------------------------------------
DRY RUN (Approach 2)
----------------------------------------------------------

Input:
nums1 = [1,2,2,1]
nums2 = [2,2]

Step 1: Store nums1 in set1
set1 = [1,2]

Step 2: Traverse nums2

j = 2 → found in set1
result = [2]
remove 2 from set1
set1 = [1]

j = 2 → not found in set1 anymore
skip

Final Output:
[2]


import java.util.*;

class Solution {
    public int[] intersection(int[] num1, int[] num2) {
        
        // Step 1: Store first array elements in HashSet
        HashSet<Integer> set1 = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i : num1) {
            set1.add(i);
        }

        // Step 2: Find common unique elements
        for (int j : num2) {
            if (set1.contains(j)) {
                result.add(j);
                set1.remove(j); // avoid duplicates
            }
        }

        // Step 3: Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
    */

/*
----------------------------------------------------------
APPROACH 3: SORTING + BINARY SEARCH
----------------------------------------------------------

Idea:
1. Sort nums1
2. Traverse nums2
3. For each element in nums2, binary search in nums1
4. Use HashSet to keep result unique
5. Convert set to array

Why it works?
- Sorting allows binary search
- HashSet avoids duplicates

Time Complexity:
- Sorting nums1 = O(n log n)
- Binary search for m elements = O(m log n)
- Total = O(n log n + m log n)

Space Complexity:
- O(k) for HashSet result
  (ignoring sorting internal space)

----------------------------------------------------------
DRY RUN (Approach 3)
----------------------------------------------------------

Input:
nums1 = [4,9,5]
nums2 = [9,4,9,8,4]

Step 1: Sort nums1
nums1 = [4,5,9]

Step 2: Traverse nums2

i = 9 → found by binary search → add 9
ans = [9]

i = 4 → found by binary search → add 4
ans = [4,9]

i = 9 → already exists in set → skip
i = 8 → not found
i = 4 → already exists in set → skip

Final Output:
[4,9]
*/

import java.util.*;

class Solution {

    // Binary Search Function
    public boolean binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                return true;
            } 
            else if (arr[mid] < target) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
        }

        return false;
    }

    public int[] intersection(int[] num1, int[] num2) {
        
        // Step 1: Sort first array
        Arrays.sort(num1);

        // Step 2: Store unique common elements
        HashSet<Integer> ans = new HashSet<>();

        for (int i : num2) {
            if (binarySearch(num1, i)) {
                ans.add(i);
            }
        }

        // Step 3: Convert set to array
        int[] result = new int[ans.size()];
        int x = 0;
        for (int i : ans) {
            result[x] = i;
            x++;
        }

        return result;
    }
}

/*
==========================================================
FINAL INTERVIEW CONCLUSION
==========================================================

Best Approach:
APPROACH 2 → HashSet + Remove

Why?
- Simple
- Optimal
- Avoids extra duplicate handling set
- Easy to explain in interviews

----------------------------------------------------------
FINAL COMPLEXITY COMPARISON
----------------------------------------------------------

Approach 1:
Time  = O(n + m)
Space = O(n + k)

Approach 2:
Time  = O(n + m)
Space = O(n + k)

Approach 3:
Time  = O(n log n + m log n)
Space = O(k)

----------------------------------------------------------
IMPORTANT NOTE
----------------------------------------------------------

This problem is:
INTERSECTION OF TWO ARRAYS
→ unique common elements only

Different from:
INTERSECTION OF TWO ARRAYS II
→ duplicates also counted
*/
