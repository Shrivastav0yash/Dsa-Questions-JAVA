class Pair {
    int number;
    int index;

    Pair(int number, int index) {
        this.number = number;
        this.index = index;
    }
}

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        
        ArrayList<Pair> list = new ArrayList<>();

        for(int i=0; i<nums.length; i++){
            list.add(new Pair(nums[i], i));
        }

        list.sort((a,b) -> {
            return Integer.compare(b.number, a.number);
        });

        list.subList(0, k).sort((a, b) -> {
            return Integer.compare(a.index, b.index);
        });

        int[] result = new int[k];

        int i = 0;
        for(Pair p : list){
            if(i < k){
                result[i] = p.number;
                i++;
            }
        }

        return result;
    }
}