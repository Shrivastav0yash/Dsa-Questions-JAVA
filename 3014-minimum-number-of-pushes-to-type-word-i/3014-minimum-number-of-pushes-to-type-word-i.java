class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        int[] map = new int[10];
        Arrays.fill(map,0);
        int assign = 2;

        for(int i=0; i<word.length(); i++){
            if(assign > 9){
                assign = 2;
            }

            map[assign]++;
            result = result + map[assign];
            assign++;

        }
        return result ;
    }
}