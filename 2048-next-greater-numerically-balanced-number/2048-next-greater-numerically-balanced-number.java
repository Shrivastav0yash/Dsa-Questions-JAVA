class Solution {

    public boolean Balanced(int num){

        int[] arr = new int[10];
        Arrays.fill(arr,0);

        while(num > 0){
            int digit = num % 10;
            arr[digit]++;
            num = num / 10;
        }

        for(int i = 0; i< arr.length; i++){
            if(arr[i] > 0 && arr[i] != i) return false;
        }

        return true;


    }

    public int nextBeautifulNumber(int n) {
        
        int largestNumber = 1224444;

        for(int x = n+1; x <= largestNumber; x++){
            if(Balanced(x)) return x;
        }

        return -1;

    }
}