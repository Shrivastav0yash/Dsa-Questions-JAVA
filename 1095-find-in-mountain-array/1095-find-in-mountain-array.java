/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int l = 0;
        int r = mountainArr.length() -1;

        while(l < r){

            int mid = l + (r - l) / 2;

            if( mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                l = mid + 1;
            }
            else{
                r = mid;
            }

        }

        return l;

    }

    public int binarySearch(MountainArray mountainArr, int l, int r, int target){
        int mid ;

        while(l <= r){
            mid = l + (r-l)/2;

            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                r = mid -1;
            }
            else{
                l = mid+1;
            }
        }

        return -1;
    }

    public int reverseBinarySearch(MountainArray mountainArr, int l, int r, int target){
        int mid ;

        while(l <= r){
            mid = l + (r-l)/2;

            if(mountainArr.get(mid) == target){
                return mid;
            }
            else if(mountainArr.get(mid) > target){
                l = mid +1;
            }
            else{
                r = mid-1;
            }
        }

        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();

        int idx = peakIndexInMountainArray(mountainArr);

        //0 to idx Binary Search
        int result_idx = binarySearch(mountainArr, 0, idx, target);

        if(result_idx != -1)
            return result_idx;
        
        result_idx = reverseBinarySearch(mountainArr, idx+1, n-1, target);

        return result_idx;

    }
}