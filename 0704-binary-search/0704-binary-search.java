class Solution {

    public int solve(int[] nums, int l, int r, int target){

        if(l > r) return -1;

        int mid = l + (r - l)/2;

        if(nums[mid] == target) return mid;
        else if(nums[mid] > target) return solve(nums, l, mid-1, target);
        else return solve(nums, mid+1, r, target);
    }
    public int search(int[] nums, int target) {
        return solve(nums, 0, nums.length -1, target);
    }
}
