//Problem Link : https://www.geeksforgeeks.org/problems/largest-element-in-array4009/1

class Solution {
    public static int largest(int[] arr) {
        // code here
        int n = arr.length;
        int result = arr[0];
        
        for(int i=0; i<n-1; i++){
            if(arr[i] < arr[i+1]){
                result = Math.max(result, arr[i+1]);
            }
        }
        
        return result;
                
    }
}