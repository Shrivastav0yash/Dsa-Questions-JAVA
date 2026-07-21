class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int result = 0;

        //for Different String
        for(int i=0; i<words.length; i++){
            String revWord = new StringBuilder(words[i]).reverse().toString();
            if(map.getOrDefault(revWord, 0) > 0){
                result += 4;
                map.put(revWord, map.getOrDefault(revWord, 0) -1);
            }else{
                map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            }
        }

        //for Same String
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String word = entry.getKey();
            int count = entry.getValue();
            if(word.charAt(0) == word.charAt(1) && count > 0){
                result += 2;
                break;
            }
        }

        return result;
    }
}