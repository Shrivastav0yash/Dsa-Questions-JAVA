class Solution {

    public int lowerBound(int l, int r, int[] potions, int target){
        int possible = -1;

        while( l <= r){
            
            int mid = l +(r-l)/2;

            if(potions[mid] >= target){
                possible = mid;
                r = mid - 1;
            }
            else{
                l = mid+1;
            }
        }

        return possible;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = spells.length;
        int n = potions.length;
        Arrays.sort(potions);
        int maxPotionValue = potions[n-1];

        int[] result = new int[m];

        for(int i = 0; i < m; i++){
            
            int spell = spells[i];

            int minPotion = (int)Math.ceil((1.0 * success) / spell);

            if(minPotion > maxPotionValue){
                result[i] = 0;
                continue;
            }

            int index = lowerBound(0, n-1, potions, minPotion);
            int count = n - index;
            result[i] = count;
        }

        return result;
    }
}