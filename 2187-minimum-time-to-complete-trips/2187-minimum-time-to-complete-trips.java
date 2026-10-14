class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        long min = Arrays.stream(time).min().getAsInt(); //to find min element in array
        long l =1;
        long r = min * totalTrips;

        while(l < r){
            long mid = l + (r - l)/2;
            long actualTrip = 0;
            for(int i : time){
                actualTrip += mid / i;
                // Optional optimization
                if (actualTrip >= totalTrips) {
                    break;
                }
            }

            if(actualTrip >= totalTrips) r = mid;
            else l = mid + 1;

        }

        return l;
    }
}