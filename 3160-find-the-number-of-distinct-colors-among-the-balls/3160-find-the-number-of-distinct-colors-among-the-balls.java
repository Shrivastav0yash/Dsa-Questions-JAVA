class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        //Map - Ball - Color
        // Map  - Color - Count
        HashMap<Integer, Integer> colorCount = new HashMap<>();
        HashMap<Integer,Integer> ballColor = new HashMap<>();
        int[] result = new int[queries.length];

        for(int i=0; i<queries.length; i++){

            int ball = queries[i][0];
            int color = queries[i][1];

            if(ballColor.containsKey(ball)){ //already color
                int prevColor = ballColor.get(ball);

                colorCount.put(prevColor, colorCount.getOrDefault(prevColor, 0) -1);
                if(colorCount.get(prevColor) == 0){
                    colorCount.remove(prevColor);
                }

            }

            ballColor.put(ball, color);
            colorCount.put(color, colorCount.getOrDefault(color, 0) +1);

            result[i] = colorCount.size();

        }

        return result;
    }
}