class Solution {
    public int majorityElement(int[] nums) {
        //Boore Moore Voting Algo
        int n = nums.length;
        int count = 0;
        int major = -1;

        for(int i : nums){
            if(count == 0){
                major = i;
                count = 1;
            }            
            else if(major == i){
                count++;
            }
            else{
                count--;
            }
        }

        return major ;

    }
}