class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-z ]", " ");
        String[] words = paragraph.split("\\s+");

        int n = words.length;

        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        for (int i = 0; i < n; i++) {
            if (!bannedSet.contains(words[i])) {
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }

        int maxFreq = 0;
        String result = "";

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;

    }
}