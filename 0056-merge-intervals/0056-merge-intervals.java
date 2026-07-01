class Solution {
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0])); //sort array
        for(int i=0;i<intervals.length;i++){
            int n = result.size();
            if(n== 0 || intervals[i][0] > result.get(n-1)[1]){
                result.add(intervals[i]); //if element not present add in list
            }
            else{
                result.get(n-1)[1] = Math.max(result.get(n-1)[1], intervals[i][1]);
                //check 3>2 or not if yes put in list
            }
        }
        int[][] ans = result.toArray(new int[result.size()][]); //convert list to array
        return ans;
    }
}