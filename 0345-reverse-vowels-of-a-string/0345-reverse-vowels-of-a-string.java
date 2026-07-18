class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;

        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        char[] arr = s.toCharArray();

        while (i < j) {
            if (!set.contains(arr[i])) {
                i++;
            } else if (!set.contains(arr[j])) {
                j--;
            } else {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }

        return new String(arr);
    }
}