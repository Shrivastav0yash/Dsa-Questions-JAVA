class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] num = new int[k];
        Arrays.fill(num, 0);

        for(int i : arr){
            int rem = (i % k + k) % k ;//handling negatives
            num[rem]++;
        }

        if(num[0] % 2 != 0) return false;

        for( int rem = 1; rem <= k/2 ; rem++){
            int remHalf = k - rem;
            if(num[remHalf] != num[rem]) return false;
        }

        return true;
    }
}