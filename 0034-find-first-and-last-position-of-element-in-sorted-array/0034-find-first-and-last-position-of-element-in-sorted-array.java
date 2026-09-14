class Solution {
    public int leftMost(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;

        int first = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                first = mid;
                r = mid - 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return first;
    }

    public int rightMost(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;

        int last = -1;

        while (l <= r) {

            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                last = mid;
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return last;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;

        int first = leftMost(nums, target, n);
        int last = rightMost(nums, target,  n);

        return new int[]{first, last};
    }
}