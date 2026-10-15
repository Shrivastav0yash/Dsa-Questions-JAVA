class Solution {
    public boolean canEatAll(int[] piles, int mid, int h){
        int actualHours = 0;
        for(int pile : piles){
            actualHours += pile/mid;
            if(pile % mid != 0) actualHours++;
        }
        return actualHours <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt(); //to find max element in array

        while( l < r){
            int mid = l + (r-l)/2;
            if(canEatAll(piles, mid, h)){
                r = mid;
            }
            else{
                l = mid +1;
            }
        }

        return l;

    }
}