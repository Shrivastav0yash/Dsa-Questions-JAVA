class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l = 0;
        int r = arr.length -1;
        int mid = -1;

        while( l <= r){
            mid = l + (r-l)/2;
            int kitne_missing = arr[mid] - (mid+1);
            if(kitne_missing < k){
                l = mid+1;
            }
            else{
                r = mid -1;
            }
        }

        return l+k;
    }
}