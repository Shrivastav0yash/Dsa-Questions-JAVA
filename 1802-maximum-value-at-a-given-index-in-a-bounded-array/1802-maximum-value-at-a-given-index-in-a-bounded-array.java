class Solution {

    public long getSumByFormula(long count, long x){
        return (count * x) - (count * (count + 1))/2;
    }

    public int maxValue(int n, int index, int maxSum) {
        long left = 1;
        long right = maxSum;
        long mid_val ;
        int result = 0;

        while(left <= right){
            mid_val = left + (right-left)/2;

            //Left Sum
            long leftCount = (long)Math.min(index, mid_val - 1);
            long leftSum = getSumByFormula(leftCount, mid_val);
            leftSum += (long)Math.max(0, index - (mid_val -1)); //extra ones if any

            //Right Sum
            long rightCount = (long)Math.min((n-index-1), mid_val - 1);
            long rightSum = getSumByFormula(rightCount, mid_val);
            rightSum += (long)Math.max(0, (n-index-1) - (mid_val -1)); //extra ones if any

            long totalSum = leftSum + mid_val + rightSum;

            if(totalSum <= maxSum){
                result = (int)Math.max(result, mid_val);
                left = mid_val + 1;
            }
            else{
                right = mid_val - 1;
            }

        }

        return result;

    }
}