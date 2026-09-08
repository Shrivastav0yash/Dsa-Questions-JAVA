class Solution {

    public String getSortedStr(int num) {

        String str = String.valueOf(num);
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String result = new String(arr);
        return result;
    }

    public boolean reorderedPowerOf2(int n) {

        String s = getSortedStr(n);

        for(int p=0; p<= 29; p++){
            if(s.equals(getSortedStr(1 << p)))
                return true;
        }

        return false;
    }
}