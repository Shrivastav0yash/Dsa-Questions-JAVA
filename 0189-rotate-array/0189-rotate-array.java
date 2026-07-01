class Solution {
    public void rotate(int[] arr, int d ) {
        // code here
        int n = arr.length;
        int k = ( d % n ); //Actual rotation
        k = n - k;
        
        int[] temp = new int[k];
        
        //copy to temp
        for(int i=0;i<k;i++){
            temp[i] = arr[i];
        }
        
        //shift by K
        for(int i=k;i<n;i++){
            arr[i-k] = arr[i];
        }
        
        //again copy to array
        for(int i=n-k;i<n;i++){
            arr[i] = temp[i-(n-k)];
        }
    }
}

