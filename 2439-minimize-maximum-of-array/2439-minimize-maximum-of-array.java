class Solution {
    public boolean isValid(int[] nums, int maxi){
        int n = nums.length;
        long[] copy = Arrays.stream(nums).asLongStream().toArray();
        
        for(int i =0; i<copy.length-1; i++){
            if(copy[i] > maxi)
                return false;
            
            long buffer = maxi - copy[i];
            copy[i+1] = (copy[i+1] - buffer);
        }

        return copy[n-1] <= maxi; 
    }

    public int minimizeArrayValue(int[] nums) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        int result = 0;

        while( l <= r){
            int mid = l + (r-l)/2;

            if(isValid(nums, mid)){
                result = mid;
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }

        return result;
    }
}