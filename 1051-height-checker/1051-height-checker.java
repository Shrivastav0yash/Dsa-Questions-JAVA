class Solution {

    public void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            // Insert key at its correct position
            arr[j + 1] = key;
        }
    }

    public int heightChecker(int[] heights) {

        int[] arr = new int[heights.length];

        for(int i=0; i<heights.length; i++){
            arr[i] = heights[i];
        }

        insertionSort(arr);

        int count = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] != heights[i])   count++;
        }

        return count;
        
    }
}