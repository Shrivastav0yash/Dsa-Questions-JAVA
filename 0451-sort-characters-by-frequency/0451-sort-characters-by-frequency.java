class Pair {
    char word;
    int freq;

    Pair(char word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        list.sort((a,b) ->{
            return Integer.compare(b.freq, a.freq);
        });

        // Step 4: Get top k
        StringBuilder result = new StringBuilder();

        for (Pair p : list) {
            for (int i = 0; i < p.freq; i++) {
                result.append(p.word);
            }
        }

        return result.toString();

    }
}