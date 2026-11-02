class Solution {

    public boolean func(int[] batteries, long mid, int n){
        long reqTime = n * mid;
        long sum = 0;

        for(int i : batteries){
            sum += Math.min(i, mid);

            if( sum >= reqTime) return true;

        }
        return false;
    }

    public long maxRunTime(int n, int[] batteries) {

        long totalTime = 0;
        for(int i : batteries){
            totalTime += i;
        }
        
        long l = Arrays.stream(batteries).min().getAsInt(); //min of batteries
        long r = totalTime / n;
        long mid = -1;
        long result = -1;

        while( l <= r){

            mid = l +(r-l)/2;

            if(func(batteries, mid, n)){
                result = mid;
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }

        }

        return result;

    }
}