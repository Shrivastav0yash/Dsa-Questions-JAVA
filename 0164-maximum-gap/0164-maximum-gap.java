class Solution {
    
    public static void radixSort(int[] arr) {
        int max = getMax(arr);

        // Apply counting sort for every digit
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // Function to get the maximum element
    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    // Counting Sort based on the digit represented by exp
    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // Count occurrences of each digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // Change count[i] so it contains the actual position
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array (iterate from end for stability)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // Copy output back to arr
        System.arraycopy(output, 0, arr, 0, n);
    }

    public int maximumGap(int[] nums) {
        
        if(nums == null || nums.length < 2) return 0;

        radixSort(nums);

        int maxG = nums[1] - nums[0];

        for(int i=2; i<nums.length; i++){
            maxG = Math.max(maxG, (nums[i] - nums[i-1]));
        }

        return maxG;
    }
}