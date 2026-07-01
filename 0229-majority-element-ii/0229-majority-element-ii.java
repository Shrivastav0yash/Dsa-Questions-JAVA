class Solution {
    public List<Integer> majorityElement(int[] nums) {
        //Boore Moore Algo
        int n = nums.length;
        List<Integer> result = new ArrayList<>();

        int count1 = 0;
        int count2 = 0;
        int majorOne = -1;
        int majorTwo = -1;

        for(int i : nums){
            if( i == majorOne){
                count1++;
            }
            else if( i == majorTwo){
                count2++;
            }
            else if( count1 == 0){
                majorOne = i;
                count1 = 1;
            }
            else if( count2 == 0){
                majorTwo = i;
                count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        //m1 = 2 , m2 = 4
        //Verfication
        int c1 = 0;
        int c2 = 0;
        for(int i : nums){
            if(majorOne == i){
                c1++;
            }
            else if(majorTwo == i){
                c2++;
            }
        }
        if(c1 > n/3) result.add(majorOne);
        if(c2 > n/3) result.add(majorTwo);

        return result;

    }
}