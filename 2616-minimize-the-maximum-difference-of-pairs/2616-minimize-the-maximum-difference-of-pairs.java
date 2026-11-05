class Solution {
    public boolean func(int[] nums, int mid, int p){
        int i = 0;
        int n = nums.length;
        int count = 0;
        while(i < n-1){

            if((nums[i+1] - nums[i]) <= mid){
                count++;
                i += 2;
            }
            else{
                i++;
            }

        }
        return count >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l = 0;
        int n = nums.length;
        int r = nums[n-1] - nums[0];
        int result = nums[n-1];

        while( l <= r ){
            int mid = l + (r - l) / 2;

            if(func(nums, mid, p)){
                result = mid;
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }

        return result;
    }
}