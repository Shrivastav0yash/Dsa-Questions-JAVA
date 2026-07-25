class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> result = new HashSet<>();
        HashSet<Integer> prev = new HashSet<>();
        

        for(int num : arr){

            HashSet<Integer> curr = new HashSet<>();

            curr.add(num);

            for(int val : prev){
                curr.add(val | num);
            }

            result.addAll(curr);

            prev = curr;

        }


        return result.size();
    }
}