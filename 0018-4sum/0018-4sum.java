class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;

        Arrays.sort(nums);

        for(int i=0;i<n;i++){
            //duplicates i
            for(int j=i+1;j<n;j++){
                int k = j+1;
                int l = n-1;
                //duplicates j
                while(k<l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum > target){
                        l--;
                    }
                    else if( sum < target){
                        k++;
                    }
                    else{
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                        temp.add(nums[l]);
                        set.add(temp);
                        k++;
                        l--;
                        //duplicates k and l 
                    }
                }
            }
        }
        List<List<Integer>> result = new ArrayList<>(set);
        return result;
    }
}