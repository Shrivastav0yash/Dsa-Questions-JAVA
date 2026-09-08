class Solution {

    HashSet<String> set = new HashSet<>();

    public void buildSet() {

        for (int p = 0; p <= 29; p++) {
            String str = String.valueOf(1 << p);
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String result = new String(arr);
            set.add(result);
        }
    }

    public boolean reorderedPowerOf2(int n) {

        if (set.isEmpty()) {
            buildSet();
        }

        String str = String.valueOf(n);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String result = new String(arr);

        return set.contains(result);

    }
}