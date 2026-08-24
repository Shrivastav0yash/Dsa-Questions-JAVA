class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;

        for(int i = 0;  i < arr.length - 1; i++ ){
            minDiff = Math.min(minDiff, Math.abs(arr[i+1] - arr[i]));
        }

        for(int i = 0; i< arr.length - 1 ; i++){
            if(Math.abs(arr[i+1] - arr[i]) == minDiff){
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i]);
                temp.add(arr[i+1]);
                result.add(temp);
            }
        }

        return result;
    }
}