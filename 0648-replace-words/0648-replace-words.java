class Solution {

    public String findRoot(HashSet<String> set, String word){

        for(int i=0; i<word.length(); i++){
            String root = word.substring(0,i);
            if(set.contains(root)){
                return root;
            }
        }

        return word;

    }

    public String replaceWords(List<String> dictionary, String sentence) {
        HashSet<String> set = new HashSet<>();

        for(int i = 0 ; i<dictionary.size(); i++){
            set.add(dictionary.get(i));
        }

        String[] words = sentence.split(" ");
        String resultSen = "";

        for(int i=0; i<words.length; i++){
            String word = words[i];
            resultSen = resultSen + findRoot(set, word) + " ";
        }

        return resultSen.substring(0, resultSen.length()-1);
    }
}