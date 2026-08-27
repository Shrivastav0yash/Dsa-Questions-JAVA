class Pair {
    String word;
    int freq;

    Pair(String word, int freq) {
        this.word = word;
        this.freq = freq;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> mp = new HashMap<>();

        // Step 1: Count frequency
        for (String word : words) {
            mp.put(word, mp.getOrDefault(word, 0) + 1);
        }

        // Step 2: Put {word, frequency} into list
        List<Pair> list = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : mp.entrySet()) {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        // Step 3: Sort
        list.sort((a, b) -> {

            // Same frequency -> alphabetical order
            if (a.freq == b.freq) {
                return a.word.compareTo(b.word);
            }

            // Higher frequency first
            return Integer.compare(b.freq, a.freq);
        });

        // Step 4: Get top k
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k && i < list.size(); i++) {
            result.add(list.get(i).word);
        }

        return result;
    }
}