class Solution {

    public int minValue(int[] nums, int n){
        int l = 0;
        int r = n-1;

        while(l < r){
            int mid = l + (r -l)/2;

            if(nums[mid] > nums[r]) l = mid + 1;
            else r = mid;
        }

        return r;
    }

    public int binarySearch(int l, int r, int[] nums, int target){

        int ind = -1;

        while(l <= r){
            int mid = l + (r -l)/2;

            if(nums[mid] == target){
                ind = mid;
                break;
            }
            else if(nums[mid] < target){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
            
        }
        return ind;

    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        int minVal = minValue(nums,n);

        int ind = binarySearch(0, minVal -1, nums, target);

        if(ind != -1) return ind;

        ind = binarySearch(minVal,  n-1, nums, target);

        return ind;
    }
}