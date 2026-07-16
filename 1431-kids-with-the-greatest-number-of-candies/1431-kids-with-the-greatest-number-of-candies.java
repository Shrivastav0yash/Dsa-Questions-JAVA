class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = Integer.MIN_VALUE;

        for(int i : candies){
            maxCandies = Math.max(i, maxCandies);
        }

        for(int i : candies){
            int newCandies = i + extraCandies;
            if(newCandies >= maxCandies){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }

        return result;
    }
}