class Solution {

    public void bubbleSort(int[] arr){
        for(int i=0; i<arr.length - 1; i++){
            for(int j=0; j<arr.length - i - 1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public int heightChecker(int[] heights) {

        int[] arr = new int[heights.length];

        for(int i=0; i<heights.length; i++){
            arr[i] = heights[i];
        }

        bubbleSort(arr);

        int count = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] != heights[i])   count++;
        }

        return count;
        
    }
}