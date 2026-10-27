class Solution {
    public Double Calculate(int[] dist, int speed){
        Double time = 0.0;
        for(int i=0; i<dist.length -1; i++){
            double t = (double)dist[i]/(double)speed;
            time += Math.ceil(t);
        }
        return time + (double)dist[dist.length -1]/(double)speed;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int l = 1;
        int r = (int) 1e7;       // Explicit casting
        int result = -1;

        while( l <= r){
            int mid = l + (r - l) / 2;

            Double hours = Calculate(dist, mid);

            if(hours <= hour){
                result = mid;
                r = mid -1;
            }
            else{
                l = mid + 1;
            }

        }

        return result;

    }
}