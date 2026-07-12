class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int totalRabbits = 0;

        for(int i : answers){
            map.put(i, map.getOrDefault(i,0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            int groupSize = entry.getKey() + 1;
            int count = entry.getValue();
            int group = (int) Math.ceil((double) count/groupSize);
            int rabbit = group * groupSize;
            totalRabbits = totalRabbits + rabbit;
        }

        return totalRabbits;

    }
}
