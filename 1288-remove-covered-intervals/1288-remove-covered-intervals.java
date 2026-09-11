class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }

            return Integer.compare(b[1], a[1]);
        });

        int lastInterval = intervals[0][1];
        int count = 1;

        for(int i=1; i<n; i++){

            if(lastInterval >= intervals[i][1]){
                    continue;
                }

            lastInterval = intervals[i][1];
            count++;
        }

        return count;   

    }
}